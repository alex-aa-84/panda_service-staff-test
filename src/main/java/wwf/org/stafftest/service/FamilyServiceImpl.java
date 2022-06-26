package wwf.org.stafftest.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Family;
import wwf.org.stafftest.entity.Relationship;
import wwf.org.stafftest.repository.FamilyRepository;
import wwf.org.stafftest.serviceApi.MD5Util;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    public Family createFamily(Family family) {
        family.setStatus("CREATED");
        family.setCreation_date(new Date());
        family.setLast_update_date(new Date());

        String md5 = MD5Util.string2MD5(family.toString());
        family.setCtrlMd5(md5);

        return familyRepository.save(family);
    }

    @Override
    public Family updateFamily(Family family) {
        Family familyDB = getFamily(family.getId());
        if(null == familyDB){
            return null;
        }

        familyDB.setUserId(family.getUserId());
        familyDB.setRelationship(family.getRelationship());
        familyDB.setName(family.getName());
        familyDB.setBirthDate(family.getBirthDate());
        familyDB.setDescription(family.getDescription());

        familyDB.setAttribute1(family.getAttribute1());
        familyDB.setAttribute2(family.getAttribute2());
        familyDB.setAttribute3(family.getAttribute3());
        familyDB.setAttribute4(family.getAttribute4());
        familyDB.setAttribute5(family.getAttribute5());
        familyDB.setAttribute6(family.getAttribute6());
        familyDB.setAttribute7(family.getAttribute7());
        familyDB.setAttribute8(family.getAttribute8());
        familyDB.setAttribute9(family.getAttribute9());
        familyDB.setAttribute10(family.getAttribute10());

        familyDB.setStatus(family.getStatus());

        familyDB.setLast_update_by(family.getLast_update_by());
        familyDB.setLast_update_date(new Date());

        return familyRepository.save(familyDB);
    }

    @Override
    public Boolean deleteFamily(Long id) {
        Family familyDB = getFamily(id);
        if(null == familyDB){
            return false;
        }

        familyRepository.deleteById(id);
        return true;
    }
}
