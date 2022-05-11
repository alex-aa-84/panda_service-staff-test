package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.BloodType;
import wwf.org.stafftest.repository.BloodTypeRepository;

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
    public BloodType createBloodType(BloodType bloodType, Long userId) {
        bloodType.setStatus("CREATED");
        bloodType.setCreate_by(userId);
        bloodType.setCreation_date(new Date());
        bloodType.setLast_update_by(userId);
        bloodType.setLast_update_date(new Date());

        return bloodTypeRepository.save(bloodType);
    }

    @Override
    public BloodType updateBloodType(BloodType bloodType, Long userId) {
        BloodType bloodTypeDB = getBloodType(bloodType.getId());
        if(null == bloodTypeDB){
            return null;
        }

        bloodType.setLast_update_by(userId);
        bloodType.setLast_update_date(new Date());

        return bloodTypeRepository.save(bloodType);
    }

    @Override
    public BloodType deleteBloodType(Long id, Long userId) {
        BloodType bloodTypeDB = getBloodType(id);
        if(null == bloodTypeDB){
            return null;
        }

        bloodTypeDB.setStatus("DELETED");
        bloodTypeDB.setLast_update_by(userId);
        bloodTypeDB.setLast_update_date(new Date());

        return bloodTypeRepository.save(bloodTypeDB);
    }
}
