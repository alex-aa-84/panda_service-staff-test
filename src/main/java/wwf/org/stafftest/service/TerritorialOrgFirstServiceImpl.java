package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.TerritorialOrgFirst;
import wwf.org.stafftest.repository.TerritorialOrgFirstRepository;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TerritorialOrgFirstServiceImpl implements TerritorialOrgFirstService {

    @Autowired
    private TerritorialOrgFirstRepository territorialOrgFirstRepository;

    @Override
    public List<TerritorialOrgFirst> listAllTerritorialOrgFirst() {
        return territorialOrgFirstRepository.findAll();
    }

    @Override
    public TerritorialOrgFirst getTerritorialOrgFirst(Long id) {
        return territorialOrgFirstRepository.findById(id).orElse(null);
    }

    @Override
    public TerritorialOrgFirst createTerritorialOrgFirst(TerritorialOrgFirst territorialOrgFirst) {
        territorialOrgFirst.setStatus("CREATED");
        territorialOrgFirst.setCreation_date(new Date());
        territorialOrgFirst.setLast_update_date(new Date());

        return territorialOrgFirstRepository.save(territorialOrgFirst);
    }

    @Override
    public TerritorialOrgFirst updateTerritorialOrgFirst(TerritorialOrgFirst territorialOrgFirst) {
        TerritorialOrgFirst territorialOrgFirstDB = getTerritorialOrgFirst(territorialOrgFirst.getId());
        if(null == territorialOrgFirstDB){
            return null;
        }

        territorialOrgFirstDB.setCountryId(territorialOrgFirst.getCountryId());
        territorialOrgFirstDB.setName(territorialOrgFirst.getName());

        territorialOrgFirstDB.setAttribute1(territorialOrgFirst.getAttribute1());
        territorialOrgFirstDB.setAttribute2(territorialOrgFirst.getAttribute2());
        territorialOrgFirstDB.setAttribute3(territorialOrgFirst.getAttribute3());
        territorialOrgFirstDB.setAttribute4(territorialOrgFirst.getAttribute4());
        territorialOrgFirstDB.setAttribute5(territorialOrgFirst.getAttribute5());
        territorialOrgFirstDB.setAttribute6(territorialOrgFirst.getAttribute6());
        territorialOrgFirstDB.setAttribute7(territorialOrgFirst.getAttribute7());
        territorialOrgFirstDB.setAttribute8(territorialOrgFirst.getAttribute8());
        territorialOrgFirstDB.setAttribute9(territorialOrgFirst.getAttribute9());
        territorialOrgFirstDB.setAttribute10(territorialOrgFirst.getAttribute10());

        territorialOrgFirstDB.setStatus(territorialOrgFirst.getStatus());

        territorialOrgFirstDB.setLast_update_by(territorialOrgFirst.getLast_update_by());
        territorialOrgFirstDB.setLast_update_date(new Date());

        return territorialOrgFirstRepository.save(territorialOrgFirstDB);
    }

    @Override
    public Boolean deleteTerritorialOrgFirst(Long id) {
        TerritorialOrgFirst territorialOrgFirstDB = getTerritorialOrgFirst(id);
        if(null == territorialOrgFirstDB){
            return false;
        }

        territorialOrgFirstRepository.deleteById(id);
        return true;
    }

    @Override
    public TerritorialOrgFirst findByCountryIdAndName(Long countryId, String name) {
        return territorialOrgFirstRepository.findByCountryIdAndName(countryId, name);
    }
}
