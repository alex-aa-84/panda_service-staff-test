package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.Profession;
import wwf.org.staff.service.ProfessionService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService service;


    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<Profession>> listData(){
        List<Profession> data = service.listAllProfession();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profession> getData(@PathVariable("id") Long id){
        Profession data = service.getProfession(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<Profession> createData(@Valid @RequestBody Profession data, BindingResult result){

        Profession dataBD = service.findByName(data.getName());

        if (null != dataBD){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProfession(data));
    }

    @PutMapping()
    public ResponseEntity<Profession> updateDate(@Valid @RequestBody Profession data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        Profession dataUp = service.updateProfession(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteProfession(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
