package wwf.org.stafftest.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Profession;
import wwf.org.stafftest.entity.ProfessionType;
import wwf.org.stafftest.repository.ProfessionRepository;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    public Profession createProfession(Profession profession) {
        profession.setStatus("CREATED");
        profession.setCreation_date(new Date());
        profession.setLast_update_date(new Date());

        return professionRepository.save(profession);
    }

    @Override
    public Profession updateProfession(Profession profession) {
        Profession professionBD = getProfession(profession.getId());
        if(null == professionBD){
            return null;
        }

        professionBD.setUserId(profession.getUserId());
        professionBD.setProfessionType(profession.getProfessionType());
        professionBD.setName(profession.getName());
        professionBD.setDescription(profession.getDescription());

        professionBD.setAttribute1(profession.getAttribute1());
        professionBD.setAttribute2(profession.getAttribute2());
        professionBD.setAttribute3(profession.getAttribute3());
        professionBD.setAttribute4(profession.getAttribute4());
        professionBD.setAttribute5(profession.getAttribute5());
        professionBD.setAttribute6(profession.getAttribute6());
        professionBD.setAttribute7(profession.getAttribute7());
        professionBD.setAttribute8(profession.getAttribute8());
        professionBD.setAttribute9(profession.getAttribute9());
        professionBD.setAttribute10(profession.getAttribute10());

        professionBD.setStatus(profession.getStatus());

        professionBD.setLast_update_by(profession.getLast_update_by());
        professionBD.setLast_update_date(new Date());

        return professionRepository.save(professionBD);
    }

    @Override
    public Boolean deleteProfession(Long id) {
        Profession professionBD = getProfession(id);
        if(null == professionBD){
            return false;
        }

        professionRepository.deleteById(id);
        return true;
    }

    @Override
    public Profession findByName(String name) {
        return professionRepository.findByName(name);
    }
}
