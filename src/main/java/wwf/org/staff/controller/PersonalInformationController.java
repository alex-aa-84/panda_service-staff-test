package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.PersonalInformation;
import wwf.org.staff.service.PersonalInformationService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/personalinformation")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService service;

    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<PersonalInformation>> listData(){
        List<PersonalInformation> data = service.listAllPersonalInformation();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonalInformation> getData(@PathVariable("id") Long id){
        PersonalInformation data = service.getPersonalInformation(id);
        if(null == data){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<PersonalInformation> getDataUser(@PathVariable("id") Long id){
        PersonalInformation data = service.findByUserId(id);
        if(null == data){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<PersonalInformation> createData(@Valid @RequestBody PersonalInformation data, BindingResult result){

        PersonalInformation dataBD = service.findByUserId(data.getUserId());

        if (null != dataBD){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPersonalInformation(data));
    }

    @PutMapping()
    public ResponseEntity<PersonalInformation> updateDate(@Valid @RequestBody PersonalInformation data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        PersonalInformation dataUp = service.updatePersonalInformation(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deletePersonalInformation(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    };
}