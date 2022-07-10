package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TerritorialOrgFour;
import wwf.org.staff.entity.TerritorialOrgThree;
import wwf.org.staff.repository.TerritorialOrgFourRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TerritorialOrgFourServiceImpl implements TerritorialOrgFourService {

    @Autowired
    private TerritorialOrgFourRepository territorialOrgFourRepository;

    @Override
    public List<TerritorialOrgFour> listAllTerritorialOrgFour() {
        return territorialOrgFourRepository.findAll();
    }

    @Override
    public TerritorialOrgFour getTerritorialOrgFour(Long id) {
        return territorialOrgFourRepository.findById(id).orElse(null);
    }

    @Override
    public TerritorialOrgFour createTerritorialOrgFour(TerritorialOrgFour territorialOrgFour) {
        territorialOrgFour.setStatus("CREATED");
        territorialOrgFour.setCreation_date(new Date());
        territorialOrgFour.setLast_update_date(new Date());

        return territorialOrgFourRepository.save(territorialOrgFour);
    }

    @Override
    public TerritorialOrgFour updateTerritorialOrgFour(TerritorialOrgFour territorialOrgFour) {
        TerritorialOrgFour territorialOrgFourDB = getTerritorialOrgFour(territorialOrgFour.getId());
        if(null == territorialOrgFourDB){
            return null;
        }

        territorialOrgFourDB.setTerritorialOrgThree(territorialOrgFour.getTerritorialOrgThree());
        territorialOrgFourDB.setName(territorialOrgFour.getName());

        territorialOrgFourDB.setAttribute1(territorialOrgFour.getAttribute1());
        territorialOrgFourDB.setAttribute2(territorialOrgFour.getAttribute2());
        territorialOrgFourDB.setAttribute3(territorialOrgFour.getAttribute3());
        territorialOrgFourDB.setAttribute4(territorialOrgFour.getAttribute4());
        territorialOrgFourDB.setAttribute5(territorialOrgFour.getAttribute5());
        territorialOrgFourDB.setAttribute6(territorialOrgFour.getAttribute6());
        territorialOrgFourDB.setAttribute7(territorialOrgFour.getAttribute7());
        territorialOrgFourDB.setAttribute8(territorialOrgFour.getAttribute8());
        territorialOrgFourDB.setAttribute9(territorialOrgFour.getAttribute9());
        territorialOrgFourDB.setAttribute10(territorialOrgFour.getAttribute10());

        territorialOrgFourDB.setStatus(territorialOrgFour.getStatus());

        territorialOrgFourDB.setLast_update_by(territorialOrgFour.getLast_update_by());
        territorialOrgFourDB.setLast_update_date(new Date());

        return territorialOrgFourRepository.save(territorialOrgFourDB);
    }

    @Override
    public Boolean deleteTerritorialOrgFour(Long id) {
        TerritorialOrgFour territorialOrgFourDB = getTerritorialOrgFour(id);
        if(null == territorialOrgFourDB){
            return false;
        }

        territorialOrgFourRepository.deleteById(id);
        return true;
    }

    @Override
    public TerritorialOrgFour findByTerritorialOrgThreeIdAndName(TerritorialOrgThree territorialOrgThree, String name) {
        return territorialOrgFourRepository.findByTerritorialOrgThreeIdAndName(territorialOrgThree.getId(), name);
    }
}
