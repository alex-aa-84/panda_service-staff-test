package wwf.org.stafftest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.stafftest.entity.TerritorialOrgFour;
import wwf.org.stafftest.service.TerritorialOrgFourService;
import wwf.org.stafftest.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/territorialorgfour")
public class TerritorialOrgFourController {

    @Autowired
    private TerritorialOrgFourService service;


    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<TerritorialOrgFour>> listData(){
        List<TerritorialOrgFour> data = service.listAllTerritorialOrgFour();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TerritorialOrgFour> getData(@PathVariable("id") Long id){
        TerritorialOrgFour data = service.getTerritorialOrgFour(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<TerritorialOrgFour> createData(@Valid @RequestBody TerritorialOrgFour data, BindingResult result){

        TerritorialOrgFour dataBD = service.findByTerritorialOrgThreeIdAndName(data.getTerritorialOrgThree(), data.getName());

        if (null != dataBD){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTerritorialOrgFour(data));
    }

    @PutMapping()
    public ResponseEntity<TerritorialOrgFour> updateDate(@Valid @RequestBody TerritorialOrgFour data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        TerritorialOrgFour dataUp = service.updateTerritorialOrgFour(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteTerritorialOrgFour(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
