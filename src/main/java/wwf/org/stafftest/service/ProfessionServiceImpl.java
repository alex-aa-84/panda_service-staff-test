package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Profession;
import wwf.org.stafftest.repository.ProfessionRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionRepository professionRepository;

    @Override
    public List<Profession> listAllProfession() {
        return professionRepository.findAll();
    }

    @Override
    public Profession getProfession(Long id) {
        return professionRepository.findById(id).orElse(null);
    }

    @Override
    public Profession createProfession(Profession profession, Long userId) {
        profession.setStatus("CREATED");
        profession.setCreate_by(userId);
        profession.setCreation_date(new Date());
        profession.setLast_update_by(userId);
        profession.setLast_update_date(new Date());

        return professionRepository.save(profession);
    }

    @Override
    public Profession updateProfession(Profession profession, Long userId) {
        Profession professionBD = getProfession(profession.getId());
        if(null == professionBD){
            return null;
        }

        profession.setLast_update_by(userId);
        profession.setLast_update_date(new Date());

        return professionRepository.save(profession);
    }

    @Override
    public Profession deleteProfession(Long id, Long userId) {
        Profession professionBD = getProfession(id);
        if(null == professionBD){
            return null;
        }

        professionBD.setStatus("DELETED");
        professionBD.setLast_update_by(userId);
        professionBD.setLast_update_date(new Date());

        return professionRepository.save(professionBD);
    }
}
