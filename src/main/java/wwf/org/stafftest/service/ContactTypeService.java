package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.ContactType;

import java.util.List;

public interface ContactTypeService {
    public List<ContactType> listAllContactType();
    public ContactType getContactType(Long id);

    public ContactType createContactType(ContactType contactType);
    public ContactType updateContactType(ContactType contactType);
    public Boolean deleteContactType(Long id);
    public ContactType findByContactType(String contactType);
}
