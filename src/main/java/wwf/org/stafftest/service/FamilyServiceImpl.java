package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Family;
import wwf.org.stafftest.repository.FamilyRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService{

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public List<Family> listAllFamily() {
        return familyRepository.findAll();
    }

    @Override
    public Family getFamily(Long id) {
        return familyRepository.findById(id).orElse(null);
    }

    @Override
    public Family createFamily(Family family, Long userId) {
        family.setStatus("CREATED");
        family.setCreate_by(userId);
        family.setCreation_date(new Date());
        family.setLast_update_by(userId);
        family.setLast_update_date(new Date());

        return familyRepository.save(family);
    }

    @Override
    public Family updateFamily(Family family, Long userId) {
        Family familyDB = getFamily(family.getId());
        if(null == familyDB){
            return null;
        }

        family.setLast_update_by(userId);
        family.setLast_update_date(new Date());

        return familyRepository.save(family);
    }

    @Override
    public Family deleteFamily(Long id, Long userId) {
        Family familyDB = getFamily(id);
        if(null == familyDB){
            return null;
        }

        familyDB.setStatus("DELETED");
        familyDB.setLast_update_by(userId);
        familyDB.setLast_update_date(new Date());

        return familyRepository.save(familyDB);
    }
}
