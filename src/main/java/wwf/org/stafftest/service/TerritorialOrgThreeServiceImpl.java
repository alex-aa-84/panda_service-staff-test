package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.TerritorialOrgFirst;
import wwf.org.stafftest.entity.TerritorialOrgThree;
import wwf.org.stafftest.entity.TerritorialOrgTwo;
import wwf.org.stafftest.repository.TerritorialOrgThreeRepository;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TerritorialOrgThreeServiceImpl implements TerritorialOrgThreeService {

    @Autowired
    private TerritorialOrgThreeRepository territorialOrgThreeRepository;

    @Override
    public List<TerritorialOrgThree> listAllTerritorialOrgThree() {
        return territorialOrgThreeRepository.findAll();
    }

    @Override
    public TerritorialOrgThree getTerritorialOrgThree(Long id) {
        return territorialOrgThreeRepository.findById(id).orElse(null);
    }

    @Override
    public TerritorialOrgThree createTerritorialOrgThree(TerritorialOrgThree territorialOrgThree) {
        territorialOrgThree.setStatus("CREATED");
        territorialOrgThree.setCreation_date(new Date());
        territorialOrgThree.setLast_update_date(new Date());

        return territorialOrgThreeRepository.save(territorialOrgThree);
    }

    @Override
    public TerritorialOrgThree updateTerritorialOrgThree(TerritorialOrgThree territorialOrgThree) {
        TerritorialOrgThree territorialOrgThreeDB = getTerritorialOrgThree(territorialOrgThree.getId());
        if(null == territorialOrgThreeDB){
            return null;
        }

        //territorialOrgThreeDB.setTerritorialOrgTwo(territorialOrgThree.getTerritorialOrgTwo());
        territorialOrgThreeDB.setName(territorialOrgThree.getName());

        territorialOrgThreeDB.setAttribute1(territorialOrgThree.getAttribute1());
        territorialOrgThreeDB.setAttribute2(territorialOrgThree.getAttribute2());
        territorialOrgThreeDB.setAttribute3(territorialOrgThree.getAttribute3());
        territorialOrgThreeDB.setAttribute4(territorialOrgThree.getAttribute4());
        territorialOrgThreeDB.setAttribute5(territorialOrgThree.getAttribute5());
        territorialOrgThreeDB.setAttribute6(territorialOrgThree.getAttribute6());
        territorialOrgThreeDB.setAttribute7(territorialOrgThree.getAttribute7());
        territorialOrgThreeDB.setAttribute8(territorialOrgThree.getAttribute8());
        territorialOrgThreeDB.setAttribute9(territorialOrgThree.getAttribute9());
        territorialOrgThreeDB.setAttribute10(territorialOrgThree.getAttribute10());

        territorialOrgThreeDB.setStatus(territorialOrgThree.getStatus());

        territorialOrgThreeDB.setLast_update_by(territorialOrgThree.getLast_update_by());
        territorialOrgThreeDB.setLast_update_date(new Date());

        return territorialOrgThreeRepository.save(territorialOrgThreeDB);
    }

    @Override
    public Boolean deleteTerritorialOrgThree(Long id) {
        TerritorialOrgThree territorialOrgThreeDB = getTerritorialOrgThree(id);
        if(null == territorialOrgThreeDB){
            return false;
        }

        territorialOrgThreeRepository.deleteById(id);
        return true;
    }

    @Override
    public TerritorialOrgThree findByTerritorialOrgTwoIdAndName(TerritorialOrgTwo territorialOrgTwo, String name) {
      //return territorialOrgThreeRepository.findByTerritorialOrgTwoIdAndName(territorialOrgTwo.getId(), name);
        return null;
    }
}
