package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.BloodType;
import wwf.org.staff.repository.BloodTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodTypeServiceImpl implements BloodTypeService{

    @Autowired
    private BloodTypeRepository bloodTypeRepository;

    @Override
    public List<BloodType> listAllBloodType() {
        return bloodTypeRepository.findAll();
    }

    @Override
    public BloodType getBloodType(Long id) {
        return bloodTypeRepository.findById(id).orElse(null);
    }

    @Override
    public BloodType createBloodType(BloodType bloodType) {
        bloodType.setStatus("CREATED");
        bloodType.setCreation_date(new Date());
        bloodType.setLast_update_date(new Date());

        return bloodTypeRepository.save(bloodType);
    }

    @Override
    public BloodType updateBloodType(BloodType bloodType) {
        BloodType bloodTypeDB = getBloodType(bloodType.getId());
        if(null == bloodTypeDB){
            return null;
        }

        bloodTypeDB.setName(bloodType.getName());
        bloodTypeDB.setDescription(bloodType.getDescription());

        bloodTypeDB.setAttribute1(bloodType.getAttribute1());
        bloodTypeDB.setAttribute2(bloodType.getAttribute2());
        bloodTypeDB.setAttribute3(bloodType.getAttribute3());
        bloodTypeDB.setAttribute4(bloodType.getAttribute4());
        bloodTypeDB.setAttribute5(bloodType.getAttribute5());
        bloodTypeDB.setAttribute6(bloodType.getAttribute6());
        bloodTypeDB.setAttribute7(bloodType.getAttribute7());
        bloodTypeDB.setAttribute8(bloodType.getAttribute8());
        bloodTypeDB.setAttribute9(bloodType.getAttribute9());
        bloodTypeDB.setAttribute10(bloodType.getAttribute10());

        bloodTypeDB.setStatus(bloodType.getStatus());

        bloodTypeDB.setLast_update_by(bloodType.getLast_update_by());
        bloodTypeDB.setLast_update_date(new Date());

        return bloodTypeRepository.save(bloodTypeDB);
    }

    @Override
    public Boolean deleteBloodType(Long id) {
        BloodType bloodTypeDB = getBloodType(id);
        if(null == bloodTypeDB){
            return false;
        }

        bloodTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public BloodType findByName(String name) {
        return bloodTypeRepository.findByName(name);
    }
}
