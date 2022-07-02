package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.AddressType;
import wwf.org.stafftest.repository.AddressTypeRepository;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    public AddressType createAddressType(AddressType addressType) {
        addressType.setStatus("CREATED");
        addressType.setCreation_date(new Date());
        addressType.setLast_update_date(new Date());

        return addressTypeRepository.save(addressType);
    }

    @Override
    public AddressType updateAddressType(AddressType addressType) {
        AddressType addressTypeDB = getAddressType(addressType.getId());
        if(null == addressTypeDB){
            return null;
        }

        addressTypeDB.setAddressType(addressType.getAddressType());
        addressTypeDB.setDescription(addressType.getDescription());

        addressTypeDB.setAttribute1(addressType.getAttribute1());
        addressTypeDB.setAttribute2(addressType.getAttribute2());
        addressTypeDB.setAttribute3(addressType.getAttribute3());
        addressTypeDB.setAttribute4(addressType.getAttribute4());
        addressTypeDB.setAttribute5(addressType.getAttribute5());
        addressTypeDB.setAttribute6(addressType.getAttribute6());
        addressTypeDB.setAttribute7(addressType.getAttribute7());
        addressTypeDB.setAttribute8(addressType.getAttribute8());
        addressTypeDB.setAttribute9(addressType.getAttribute9());
        addressTypeDB.setAttribute10(addressType.getAttribute10());

        addressTypeDB.setStatus(addressType.getStatus());

        addressTypeDB.setLast_update_by(addressType.getLast_update_by());
        addressTypeDB.setLast_update_date(new Date());

        return addressTypeRepository.save(addressTypeDB);
    }

    @Override
    public Boolean deleteAddressType(Long id) {
        AddressType addressTypeDB = getAddressType(id);
        if(null == addressTypeDB){
            return false;
        }

        addressTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public AddressType findByAddressType(String addressType) {
        return addressTypeRepository.findByAddressType(addressType);
    }
}
