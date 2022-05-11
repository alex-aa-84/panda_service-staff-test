package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> listAllContact();
    public Contact getContact(Long id);

    public Contact createContact(Contact contact, Long userId);
    public Contact updateContact(Contact contact, Long userId);
    public Contact deleteContact(Long id, Long userId);
}