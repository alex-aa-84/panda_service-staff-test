package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.ContactType;

import java.util.List;

public interface ContactTypeService {
    public List<ContactType> listAllContactType();
    public ContactType getContactType(Long id);

    public ContactType createContactType(ContactType contactType, Long userId);
    public ContactType updateContactType(ContactType contactType, Long userId);
    public ContactType deleteContactType(Long id, Long userId);
}
