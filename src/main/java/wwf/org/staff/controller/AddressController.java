package wwf.org.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wwf.org.staff.entity.Address;
import wwf.org.staff.service.AddressService;
import wwf.org.staff.serviceApi.FormatMessage;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"${settings.cors_origin}", "${settings.cors_origin_pro}"}, maxAge = 3600,
        allowedHeaders={"Origin", "X-Requested-With", "Content-Type", "Accept", "x-client-key", "x-client-token", "x-client-secret", "Authorization"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping(value="/admstaffwwf/address")
public class AddressController {

    @Autowired
    private AddressService service;


    private FormatMessage formatMessage = new FormatMessage();

    @GetMapping
    public ResponseEntity<List<Address>> listData(){
        List<Address> data = service.listAllAddress();
        if(data.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> getData(@PathVariable("id") Long id){
        Address data = service.getAddress(id);
        if(null == data){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<Address> createData(@Valid @RequestBody Address data, BindingResult result){

        Address dataBD = service.findByNeighborhoodAndStreetAndNumber(data.getNeighborhood(), data.getStreet(), data.getNumber());

        if (null != dataBD){
            FieldError err = new FieldError("Error", "registroExistente", "registroExistenteBD");
            result.addError(err);
        }

        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAddress(data));
    }

    @PutMapping()
    public ResponseEntity<Address> updateDate(@Valid @RequestBody Address data, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessage.format(result));
        }

        Address dataUp = service.updateAddress(data);
        if(null == dataUp){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dataUp);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteData(@PathVariable("id") Long id){

        Boolean action = service.deleteAddress(id);

        if ( action){
            return ResponseEntity.ok(action);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
