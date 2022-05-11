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
    public ContactType createContactType(ContactType contactType, Long userId) {
        contactType.setStatus("CREATED");
        contactType.setCreate_by(userId);
        contactType.setCreation_date(new Date());
        contactType.setLast_update_by(userId);
        contactType.setLast_update_date(new Date());

        return contactTypeRepository.save(contactType);
    }

    @Override
    public ContactType updateContactType(ContactType contactType, Long userId) {
        ContactType contactTypeDB = getContactType(contactType.getId());
        if(null == contactTypeDB){
            return null;
        }

        contactType.setLast_update_by(userId);
        contactType.setLast_update_date(new Date());

        return contactTypeRepository.save(contactType);
    }

    @Override
    public ContactType deleteContactType(Long id, Long userId) {
        ContactType contactTypeDB = getContactType(id);
        if(null == contactTypeDB){
            return null;
        }

        contactTypeDB.setStatus("DELETED");
        contactTypeDB.setLast_update_by(userId);
        contactTypeDB.setLast_update_date(new Date());

        return contactTypeRepository.save(contactTypeDB);
    }
}
