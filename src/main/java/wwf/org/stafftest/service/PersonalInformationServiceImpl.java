package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.PersonalInformation;
import wwf.org.stafftest.repository.PersonalInformationRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalInformationServiceImpl implements PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @Override
    public List<PersonalInformation> listAllPersonalInformation() {
        return personalInformationRepository.findAll();
    }

    @Override
    public PersonalInformation getPersonalInformation(Long id) {
        return personalInformationRepository.findById(id).orElse(null);
    }

    @Override
    public PersonalInformation createPersonalInformation(PersonalInformation personalInformation, Long userId) {
        personalInformation.setStatus("CREATED");
        personalInformation.setCreate_by(userId);
        personalInformation.setCreation_date(new Date());
        personalInformation.setLast_update_by(userId);
        personalInformation.setLast_update_date(new Date());

        return personalInformationRepository.save(personalInformation);
    }

    @Override
    public PersonalInformation updatePersonalInformation(PersonalInformation personalInformation, Long userId) {
        PersonalInformation personalInformationDB = getPersonalInformation(personalInformation.getId());
        if(null == personalInformationDB){
            return null;
        }

        personalInformation.setLast_update_by(userId);
        personalInformation.setLast_update_date(new Date());

        return personalInformationRepository.save(personalInformation);
    }

    @Override
    public PersonalInformation deletePersonalInformation(Long id, Long userId) {
        PersonalInformation personalInformationDB = getPersonalInformation(id);
        if(null == personalInformationDB){
            return null;
        }

        personalInformationDB.setStatus("DELETED");
        personalInformationDB.setLast_update_by(userId);
        personalInformationDB.setLast_update_date(new Date());

        return personalInformationRepository.save(personalInformationDB);
    }
}
