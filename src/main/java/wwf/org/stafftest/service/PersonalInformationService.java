package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.PersonalInformation;

import java.util.List;

public interface PersonalInformationService {
    public List<PersonalInformation> listAllPersonalInformation();
    public PersonalInformation getPersonalInformation(Long id);

    public PersonalInformation createPersonalInformation(PersonalInformation personalInformation, Long userId);
    public PersonalInformation updatePersonalInformation(PersonalInformation personalInformation, Long userId);
    public PersonalInformation deletePersonalInformation(Long id, Long userId);
}
