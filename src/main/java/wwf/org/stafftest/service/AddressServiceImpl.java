package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.repository.AddressRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> listAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address createAddress(Address address, Long userId) {
        address.setStatus("CREATED");
        address.setCreate_by(userId);
        address.setCreation_date(new Date());
        address.setLast_update_by(userId);
        address.setLast_update_date(new Date());

        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address, Long userId) {
        Address addressDB = getAddress(address.getId());
        if(null == addressDB){
            return null;
        }

        address.setLast_update_by(userId);
        address.setLast_update_date(new Date());

        return addressRepository.save(address);
    }

    @Override
    public Address deleteAddress(Long id, Long userId) {
        Address addressDB = getAddress(id);
        if(null == addressDB){
            return null;
        }

        addressDB.setStatus("DELETED");
        addressDB.setLast_update_by(userId);
        addressDB.setLast_update_date(new Date());

        return addressRepository.save(addressDB);
    }
}
