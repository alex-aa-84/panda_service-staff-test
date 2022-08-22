package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import wwf.org.staff.entity.TerritorialOrgConfig;
import wwf.org.staff.entity.TerritorialOrgFirst;
import wwf.org.staff.service.TerritorialOrgConfigService;
import wwf.org.staff.service.TerritorialOrgFirstService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/territorialorgfirst")
public class TerritorialOrgFirstController {

    @Autowired
    private TerritorialOrgFirstService service;

    @Autowired
    private TerritorialOrgConfigService serviceOrg;


    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<TerritorialOrgFirst>> listData(){
        List<TerritorialOrgFirst> data = service.listAllTerritorialOrgFirst();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TerritorialOrgFirst> getData(@PathVariable("id") Long id){
        TerritorialOrgFirst data = service.getTerritorialOrgFirst(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "org/{id}")
    public ResponseEntity<List<TerritorialOrgFirst>> getDataId(@PathVariable("id") Long id){
        TerritorialOrgConfig territorialOrgConfig = serviceOrg.getTerritorialOrgConfig(id);

        List<TerritorialOrgFirst> data = service.findByTerritorialOrgConfig(territorialOrgConfig);


        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<TerritorialOrgFirst> createData(@Valid @RequestBody TerritorialOrgFirst data, BindingResult result){

        TerritorialOrgFirst dataBD = service.findByTerritorialOrgConfigIdAndName(data.getTerritorialOrgConfig().getId(), data.getName());

        if (null != dataBD){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTerritorialOrgFirst(data));
    }

    @PutMapping()
    public ResponseEntity<TerritorialOrgFirst> updateDate(@Valid @RequestBody TerritorialOrgFirst data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        TerritorialOrgFirst dataUp = service.updateTerritorialOrgFirst(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteTerritorialOrgFirst(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
