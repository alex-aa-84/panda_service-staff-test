package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.AdditionalOrganization;
import wwf.org.staff.service.AdditionalOrganizationService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/additionalorg")
public class AdditionalOrganizationController {

    @Autowired
    private AdditionalOrganizationService service;

    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<AdditionalOrganization>> listData(){
        List<AdditionalOrganization> data = service.listAllAdditionalOrganization();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdditionalOrganization> getData(@PathVariable("id") Long id){
        AdditionalOrganization data = service.getAdditionalOrganization(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<AdditionalOrganization> createData(@Valid @RequestBody AdditionalOrganization data, BindingResult result){

        AdditionalOrganization dataBD = service.findByTenantIdAndAdditionalOrganizationTypeIdAndFromTimeAndUntilTimeAndFromMonthAndUntilMonthAndValue(data.getTenantId(), data.getAdditionalOrganizationType().getId(), data.getFromTime(), data.getUntilTime(), data.getFromMonth(), data.getUntilMonth(), data.getValue());

        if (null != dataBD){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAdditionalOrganization(data));
    }

    @PutMapping()
    public ResponseEntity<AdditionalOrganization> updateData(@Valid @RequestBody AdditionalOrganization data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        AdditionalOrganization dataUp = service.updateAdditionalOrganization(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteAdditionalOrganization(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
