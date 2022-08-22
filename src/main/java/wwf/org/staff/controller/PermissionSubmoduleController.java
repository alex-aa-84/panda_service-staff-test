package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import wwf.org.staff.entity.PermissionModule;
import wwf.org.staff.entity.PermissionSubmodule;
import wwf.org.staff.service.PermissionModuleService;
import wwf.org.staff.service.PermissionSubmoduleService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/permissionsubmodule")
public class PermissionSubmoduleController {

    @Autowired
    private PermissionSubmoduleService service;

    @Autowired
    private PermissionModuleService servicePMS;


    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<PermissionSubmodule>> listData(){
        List<PermissionSubmodule> data = service.listAllPermissionSubmodule();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PermissionSubmodule> getData(@PathVariable("id") Long id){
        PermissionSubmodule data = service.getPermissionSubmodule(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "list/{id}")
    public ResponseEntity<List<PermissionSubmodule>> getList(@PathVariable("id") Long id){
        PermissionModule permissionModule = servicePMS.getPermissionModule(id);
        List<PermissionSubmodule> list = service.findByPermissionModule(permissionModule);
        if(null == list){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping()
    public ResponseEntity<PermissionSubmodule> createData(@Valid @RequestBody PermissionSubmodule data, BindingResult result){

        PermissionSubmodule dataBD = service.findByPermissionModuleIdAndSubmodulesId(data.getPermissionModule().getId(), data.getSubmodulesId());

        if (null != dataBD){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPermissionSubmodule(data));
    }

    @PutMapping()
    public ResponseEntity<PermissionSubmodule> updateDate(@Valid @RequestBody PermissionSubmodule data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        PermissionSubmodule dataUp = service.updatePermissionSubmodule(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deletePermissionSubmodule(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
