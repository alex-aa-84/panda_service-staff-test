package wwf.org.stafftest.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Contact;
import wwf.org.stafftest.entity.ContactType;
import wwf.org.stafftest.repository.ContactRepository;
import wwf.org.stafftest.serviceApi.MD5Util;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
    public Contact createContact(Contact contact) {
        contact.setStatus("CREATED");
        contact.setCreation_date(new Date());
        contact.setLast_update_date(new Date());

        String md5 = MD5Util.string2MD5(contact.toString());
        contact.setCtrlMd5(md5);

        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        Contact contactDB = getContact(contact.getId());
        if(null == contactDB){
            return null;
        }

        contactDB.setUserId(contact.getUserId());
        contactDB.setContactType(contact.getContactType());
        contactDB.setPhoneNumber(contact.getPhoneNumber());
        contactDB.setEmail(contact.getEmail());
        contactDB.setDescription(contact.getDescription());

        contactDB.setAttribute1(contact.getAttribute1());
        contactDB.setAttribute2(contact.getAttribute2());
        contactDB.setAttribute3(contact.getAttribute3());
        contactDB.setAttribute4(contact.getAttribute4());
        contactDB.setAttribute5(contact.getAttribute5());
        contactDB.setAttribute6(contact.getAttribute6());
        contactDB.setAttribute7(contact.getAttribute7());
        contactDB.setAttribute8(contact.getAttribute8());
        contactDB.setAttribute9(contact.getAttribute9());
        contactDB.setAttribute10(contact.getAttribute10());

        contactDB.setStatus(contact.getStatus());

        contactDB.setLast_update_by(contact.getLast_update_by());
        contactDB.setLast_update_date(new Date());

        return contactRepository.save(contactDB);
    }

    @Override
    public Boolean deleteContact(Long id) {
        Contact contactDB = getContact(id);
        if(null == contactDB){
            return false;
        }

        contactRepository.deleteById(id);
        return true;
    }
}
