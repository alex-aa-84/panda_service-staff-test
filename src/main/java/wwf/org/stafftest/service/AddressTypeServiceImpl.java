package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.AddressType;
import wwf.org.stafftest.repository.AddressTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressTypeServiceImpl implements AddressTypeService{

    @Autowired
    private AddressTypeRepository addressTypeRepository;

    @Override
    public List<AddressType> listAllAddressType() {
        return addressTypeRepository.findAll();
    }

    @Override
    public AddressType getAddressType(Long id) {
        return addressTypeRepository.findById(id).orElse(null);
    }

    @Override
    public AddressType createAddressType(AddressType addressType, Long userId) {
        addressType.setStatus("CREATED");
        addressType.setCreate_by(userId);
        addressType.setCreation_date(new Date());
        addressType.setLast_update_by(userId);
        addressType.setLast_update_date(new Date());

        return addressTypeRepository.save(addressType);
    }

    @Override
    public AddressType updateAddressType(AddressType addressType, Long userId) {
        AddressType addressTypeDB = getAddressType(addressType.getId());
        if(null == addressTypeDB){
            return null;
        }

        addressType.setLast_update_by(userId);
        addressType.setLast_update_date(new Date());

        return addressTypeRepository.save(addressType);
    }

    @Override
    public AddressType deleteAddressType(Long id, Long userId) {
        AddressType addressTypeDB = getAddressType(id);
        if(null == addressTypeDB){
            return null;
        }

        addressTypeDB.setStatus("DELETED");
        addressTypeDB.setLast_update_by(userId);
        addressTypeDB.setLast_update_date(new Date());

        return addressTypeRepository.save(addressTypeDB);
    }
}
