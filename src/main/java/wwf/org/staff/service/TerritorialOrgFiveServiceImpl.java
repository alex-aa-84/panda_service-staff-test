package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TerritorialOrgFive;
import wwf.org.staff.entity.TerritorialOrgFour;
import wwf.org.staff.repository.TerritorialOrgFiveRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TerritorialOrgFiveServiceImpl implements TerritorialOrgFiveService {

    @Autowired
    private TerritorialOrgFiveRepository territorialOrgFiveRepository;

    @Override
    public List<TerritorialOrgFive> listAllTerritorialOrgFive() {
        return territorialOrgFiveRepository.findAll();
    }

    @Override
    public TerritorialOrgFive getTerritorialOrgFive(Long id) {
        return territorialOrgFiveRepository.findById(id).orElse(null);
    }

    @Override
    public TerritorialOrgFive createTerritorialOrgFive(TerritorialOrgFive territorialOrgFive) {
        territorialOrgFive.setStatus("CREATED");
        territorialOrgFive.setCreation_date(new Date());
        territorialOrgFive.setLast_update_date(new Date());

        return territorialOrgFiveRepository.save(territorialOrgFive);
    }

    @Override
    public TerritorialOrgFive updateTerritorialOrgFive(TerritorialOrgFive territorialOrgFive) {
        TerritorialOrgFive territorialOrgFiveDB = getTerritorialOrgFive(territorialOrgFive.getId());
        if(null == territorialOrgFiveDB){
            return null;
        }

        territorialOrgFiveDB.setTerritorialOrgFour(territorialOrgFive.getTerritorialOrgFour());
        territorialOrgFiveDB.setName(territorialOrgFive.getName());

        territorialOrgFiveDB.setAttribute1(territorialOrgFive.getAttribute1());
        territorialOrgFiveDB.setAttribute2(territorialOrgFive.getAttribute2());
        territorialOrgFiveDB.setAttribute3(territorialOrgFive.getAttribute3());
        territorialOrgFiveDB.setAttribute4(territorialOrgFive.getAttribute4());
        territorialOrgFiveDB.setAttribute5(territorialOrgFive.getAttribute5());
        territorialOrgFiveDB.setAttribute6(territorialOrgFive.getAttribute6());
        territorialOrgFiveDB.setAttribute7(territorialOrgFive.getAttribute7());
        territorialOrgFiveDB.setAttribute8(territorialOrgFive.getAttribute8());
        territorialOrgFiveDB.setAttribute9(territorialOrgFive.getAttribute9());
        territorialOrgFiveDB.setAttribute10(territorialOrgFive.getAttribute10());

        territorialOrgFiveDB.setStatus(territorialOrgFive.getStatus());

        territorialOrgFiveDB.setLast_update_by(territorialOrgFive.getLast_update_by());
        territorialOrgFiveDB.setLast_update_date(new Date());

        return territorialOrgFiveRepository.save(territorialOrgFiveDB);
    }

    @Override
    public Boolean deleteTerritorialOrgFive(Long id) {
        TerritorialOrgFive territorialOrgFiveDB = getTerritorialOrgFive(id);
        if(null == territorialOrgFiveDB){
            return false;
        }

        territorialOrgFiveRepository.deleteById(id);
        return true;
    }

    @Override
    public TerritorialOrgFive findByTerritorialOrgFourIdAndName(Long territorialOrgFourId, String name) {
        return territorialOrgFiveRepository.findByTerritorialOrgFourIdAndName(territorialOrgFourId, name);
    }
}
