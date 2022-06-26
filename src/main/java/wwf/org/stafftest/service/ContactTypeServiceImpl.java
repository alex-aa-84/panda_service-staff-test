package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.ContactType;
import wwf.org.stafftest.repository.ContactTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactTypeServiceImpl implements ContactTypeService{

    @Autowired
    private ContactTypeRepository contactTypeRepository;

    @Override
    public List<ContactType> listAllContactType() {
        return contactTypeRepository.findAll();
    }

    @Override
    public ContactType getContactType(Long id) {
        return contactTypeRepository.findById(id).orElse(null);
    }

    @Override
    public ContactType createContactType(ContactType contactType) {
        contactType.setStatus("CREATED");
        contactType.setCreation_date(new Date());
        contactType.setLast_update_date(new Date());

        return contactTypeRepository.save(contactType);
    }

    @Override
    public ContactType updateContactType(ContactType contactType) {
        ContactType contactTypeDB = getContactType(contactType.getId());
        if(null == contactTypeDB){
            return null;
        }

        contactTypeDB.setContactType(contactType.getContactType());

        contactTypeDB.setDescription(contactType.getDescription());

        contactTypeDB.setAttribute1(contactType.getAttribute1());
        contactTypeDB.setAttribute2(contactType.getAttribute2());
        contactTypeDB.setAttribute3(contactType.getAttribute3());
        contactTypeDB.setAttribute4(contactType.getAttribute4());
        contactTypeDB.setAttribute5(contactType.getAttribute5());
        contactTypeDB.setAttribute6(contactType.getAttribute6());
        contactTypeDB.setAttribute7(contactType.getAttribute7());
        contactTypeDB.setAttribute8(contactType.getAttribute8());
        contactTypeDB.setAttribute9(contactType.getAttribute9());
        contactTypeDB.setAttribute10(contactType.getAttribute10());

        contactTypeDB.setStatus(contactType.getStatus());

        contactTypeDB.setLast_update_by(contactType.getLast_update_by());
        contactTypeDB.setLast_update_date(new Date());

        return contactTypeRepository.save(contactTypeDB);
    }

    @Override
    public Boolean deleteContactType(Long id) {
        ContactType contactTypeDB = getContactType(id);
        if(null == contactTypeDB){
            return false;
        }

        contactTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public ContactType findByContactType(String contactType) {
        return contactTypeRepository.findByContactType(contactType);
    }
}
