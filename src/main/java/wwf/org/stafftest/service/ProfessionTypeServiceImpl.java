package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.ProfessionType;
import wwf.org.stafftest.repository.ProfessionTypeRepository;

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
    public ProfessionType createProfessionType(ProfessionType professionType, Long userId) {
        professionType.setStatus("CREATED");
        professionType.setCreate_by(userId);
        professionType.setCreation_date(new Date());
        professionType.setLast_update_by(userId);
        professionType.setLast_update_date(new Date());

        return professionTypeRepository.save(professionType);
    }

    @Override
    public ProfessionType updateProfessionType(ProfessionType professionType, Long userId) {
        ProfessionType professionTypeDB = getProfessionType(professionType.getId());
        if(null == professionTypeDB){
            return null;
        }

        professionType.setLast_update_by(userId);
        professionType.setLast_update_date(new Date());

        return professionTypeRepository.save(professionType);
    }

    @Override
    public ProfessionType deleteProfessionType(Long id, Long userId) {
        ProfessionType professionTypeDB = getProfessionType(id);
        if(null == professionTypeDB){
            return null;
        }

        professionTypeDB.setStatus("DELETED");
        professionTypeDB.setLast_update_by(userId);
        professionTypeDB.setLast_update_date(new Date());

        return professionTypeRepository.save(professionTypeDB);
    }
}
