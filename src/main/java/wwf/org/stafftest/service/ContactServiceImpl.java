package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Contact;
import wwf.org.stafftest.repository.ContactRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> listAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact createContact(Contact contact, Long userId) {
        contact.setStatus("CREATED");
        contact.setCreate_by(userId);
        contact.setCreation_date(new Date());
        contact.setLast_update_by(userId);
        contact.setLast_update_date(new Date());

        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact, Long userId) {
        Contact contactDB = getContact(contact.getId());
        if(null == contactDB){
            return null;
        }

        contact.setLast_update_by(userId);
        contact.setLast_update_date(new Date());

        return contactRepository.save(contact);
    }

    @Override
    public Contact deleteContact(Long id, Long userId) {
        Contact contactDB = getContact(id);
        if(null == contactDB){
            return null;
        }

        contactDB.setStatus("DELETED");
        contactDB.setLast_update_by(userId);
        contactDB.setLast_update_date(new Date());

        return contactRepository.save(contactDB);
    }
}
