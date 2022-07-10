package wwf.org.staff.service;

import wwf.org.staff.entity.PersonalInformation;

import java.util.List;

public interface PersonalInformationService {
    public List<PersonalInformation> listAllPersonalInformation();
    public PersonalInformation getPersonalInformation(Long id);

    public PersonalInformation createPersonalInformation(PersonalInformation personalInformation);
    public PersonalInformation updatePersonalInformation(PersonalInformation personalInformation);
    public Boolean deletePersonalInformation(Long id);
    public PersonalInformation findByUserId(Long userId);
}
