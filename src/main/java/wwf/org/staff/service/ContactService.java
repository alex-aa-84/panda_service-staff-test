package wwf.org.staff.service;

import wwf.org.staff.entity.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> listAllContact();
    public Contact getContact(Long id);

    public Contact createContact(Contact contact);
    public Contact updateContact(Contact contact);
    public Boolean deleteContact(Long id);

}
