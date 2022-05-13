package wwf.org.stafftest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.service.AddressService;

import java.util.List;

@RestController
@RequestMapping(value="/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> listAddress(){
        List<Address> address = addressService.listAllAddress();
        if(address.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(address);
    }

}
