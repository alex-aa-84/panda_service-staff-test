package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.ProfessionType;
import wwf.org.staff.repository.ProfessionTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionTypeServiceImpl implements ProfessionTypeService {

    @Autowired
    private ProfessionTypeRepository professionTypeRepository;

    @Override
    public List<ProfessionType> listAllProfessionType() {
        return professionTypeRepository.findAll();
    }

    @Override
    public ProfessionType getProfessionType(Long id) {
        return professionTypeRepository.findById(id).orElse(null);
    }

    @Override
    public ProfessionType createProfessionType(ProfessionType professionType) {
        professionType.setStatus("CREATED");
        professionType.setCreation_date(new Date());
        professionType.setLast_update_date(new Date());

        return professionTypeRepository.save(professionType);
    }

    @Override
    public ProfessionType updateProfessionType(ProfessionType professionType) {
        ProfessionType professionTypeDB = getProfessionType(professionType.getId());
        if(null == professionTypeDB){
            return null;
        }

        professionTypeDB.setProfessionType(professionType.getProfessionType());
        professionTypeDB.setDescription(professionType.getDescription());

        professionTypeDB.setAttribute1(professionType.getAttribute1());
        professionTypeDB.setAttribute2(professionType.getAttribute2());
        professionTypeDB.setAttribute3(professionType.getAttribute3());
        professionTypeDB.setAttribute4(professionType.getAttribute4());
        professionTypeDB.setAttribute5(professionType.getAttribute5());
        professionTypeDB.setAttribute6(professionType.getAttribute6());
        professionTypeDB.setAttribute7(professionType.getAttribute7());
        professionTypeDB.setAttribute8(professionType.getAttribute8());
        professionTypeDB.setAttribute9(professionType.getAttribute9());
        professionTypeDB.setAttribute10(professionType.getAttribute10());

        professionTypeDB.setStatus(professionType.getStatus());

        professionTypeDB.setLast_update_by(professionType.getLast_update_by());
        professionTypeDB.setLast_update_date(new Date());

        return professionTypeRepository.save(professionTypeDB);
    }

    @Override
    public Boolean deleteProfessionType(Long id) {
        ProfessionType professionTypeDB = getProfessionType(id);
        if(null == professionTypeDB){
            return false;
        }

        professionTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public ProfessionType findByProfessionType(String professionType) {
        return professionTypeRepository.findByProfessionType(professionType);
    }
}
