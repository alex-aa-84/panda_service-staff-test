package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.PersonalInformation;
import wwf.org.staff.repository.PersonalInformationRepository;

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
    public PersonalInformation createPersonalInformation(PersonalInformation personalInformation) {
        personalInformation.setStatus("CREATED");
        personalInformation.setCreation_date(new Date());
        personalInformation.setLast_update_date(new Date());

        return personalInformationRepository.save(personalInformation);
    }

    @Override
    public PersonalInformation updatePersonalInformation(PersonalInformation personalInformation) {
        PersonalInformation personalInformationDB = getPersonalInformation(personalInformation.getId());
        if(null == personalInformationDB){
            return null;
        }

        personalInformationDB.setUserId(personalInformation.getUserId());

        personalInformationDB.setNames(personalInformation.getNames());
        personalInformationDB.setSurnamePaternal(personalInformation.getSurnamePaternal());
        personalInformationDB.setSurnameMaternal(personalInformation.getSurnameMaternal());
        personalInformationDB.setSurnameMarried(personalInformation.getSurnameMarried());
        personalInformationDB.setBirthDate(personalInformation.getBirthDate());
        personalInformationDB.setCivilStatus(personalInformation.getCivilStatus());
        personalInformationDB.setBloodType(personalInformation.getBloodType());
        personalInformationDB.setCountry_id(personalInformation.getCountry_id());

        personalInformationDB.setAttribute1(personalInformation.getAttribute1());
        personalInformationDB.setAttribute2(personalInformation.getAttribute2());
        personalInformationDB.setAttribute3(personalInformation.getAttribute3());
        personalInformationDB.setAttribute4(personalInformation.getAttribute4());
        personalInformationDB.setAttribute5(personalInformation.getAttribute5());
        personalInformationDB.setAttribute6(personalInformation.getAttribute6());
        personalInformationDB.setAttribute7(personalInformation.getAttribute7());
        personalInformationDB.setAttribute8(personalInformation.getAttribute8());
        personalInformationDB.setAttribute9(personalInformation.getAttribute9());
        personalInformationDB.setAttribute10(personalInformation.getAttribute10());

        personalInformationDB.setStatus(personalInformation.getStatus());

        personalInformationDB.setLast_update_by(personalInformation.getLast_update_by());
        personalInformationDB.setLast_update_date(new Date());

        return personalInformationRepository.save(personalInformationDB);
    }

    @Override
    public Boolean deletePersonalInformation(Long id) {
        PersonalInformation personalInformationDB = getPersonalInformation(id);
        if(null == personalInformationDB){
            return false;
        }

        personalInformationRepository.deleteById(id);
        return true;
    }

    @Override
    public PersonalInformation findByUserId(Long userId) {
        return personalInformationRepository.findByUserId(userId);
    }
}
