package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TerritorialOrgFirst;
import wwf.org.staff.entity.TerritorialOrgTwo;
import wwf.org.staff.repository.TerritorialOrgTwoRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TerritorialOrgTwoServiceImpl implements TerritorialOrgTwoService {

    @Autowired
    private TerritorialOrgTwoRepository territorialOrgTwoRepository;

    @Override
    public List<TerritorialOrgTwo> listAllTerritorialOrgTwo() {
        return territorialOrgTwoRepository.findAll();
    }

    @Override
    public TerritorialOrgTwo getTerritorialOrgTwo(Long id) {
        return territorialOrgTwoRepository.findById(id).orElse(null);
    }

    @Override
    public TerritorialOrgTwo createTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo) {
        territorialOrgTwo.setStatus("CREATED");
        territorialOrgTwo.setCreation_date(new Date());
        territorialOrgTwo.setLast_update_date(new Date());

        return territorialOrgTwoRepository.save(territorialOrgTwo);
    }

    @Override
    public TerritorialOrgTwo updateTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo) {
        TerritorialOrgTwo territorialOrgTwoDB = getTerritorialOrgTwo(territorialOrgTwo.getId());
        if(null == territorialOrgTwoDB){
            return null;
        }

        territorialOrgTwoDB.setTerritorialOrgFirst(territorialOrgTwo.getTerritorialOrgFirst());
        territorialOrgTwoDB.setName(territorialOrgTwo.getName());

        territorialOrgTwoDB.setAttribute1(territorialOrgTwo.getAttribute1());
        territorialOrgTwoDB.setAttribute2(territorialOrgTwo.getAttribute2());
        territorialOrgTwoDB.setAttribute3(territorialOrgTwo.getAttribute3());
        territorialOrgTwoDB.setAttribute4(territorialOrgTwo.getAttribute4());
        territorialOrgTwoDB.setAttribute5(territorialOrgTwo.getAttribute5());
        territorialOrgTwoDB.setAttribute6(territorialOrgTwo.getAttribute6());
        territorialOrgTwoDB.setAttribute7(territorialOrgTwo.getAttribute7());
        territorialOrgTwoDB.setAttribute8(territorialOrgTwo.getAttribute8());
        territorialOrgTwoDB.setAttribute9(territorialOrgTwo.getAttribute9());
        territorialOrgTwoDB.setAttribute10(territorialOrgTwo.getAttribute10());

        territorialOrgTwoDB.setStatus(territorialOrgTwo.getStatus());

        territorialOrgTwoDB.setLast_update_by(territorialOrgTwo.getLast_update_by());
        territorialOrgTwoDB.setLast_update_date(new Date());

        return territorialOrgTwoRepository.save(territorialOrgTwoDB);
    }

    @Override
    public Boolean deleteTerritorialOrgTwo(Long id) {
        TerritorialOrgTwo territorialOrgTwoDB = getTerritorialOrgTwo(id);
        if(null == territorialOrgTwoDB){
            return false;
        }

        territorialOrgTwoRepository.deleteById(id);
        return true;
    }

    @Override
    public TerritorialOrgTwo findByTerritorialOrgFirstIdAndName(Long territorialOrgFirstId, String name) {
        return territorialOrgTwoRepository.findByTerritorialOrgFirstIdAndName(territorialOrgFirstId, name);
    }
}
