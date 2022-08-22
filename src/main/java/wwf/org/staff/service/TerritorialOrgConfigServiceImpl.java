package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TerritorialOrgConfig;
import wwf.org.staff.repository.TerritorialOrgConfigRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TerritorialOrgConfigServiceImpl implements TerritorialOrgConfigService {

    @Autowired
    private TerritorialOrgConfigRepository territorialOrgConfigRepository;

    @Override
    public List<TerritorialOrgConfig> listAllTerritorialOrgConfig() {
        return territorialOrgConfigRepository.findAll();
    }

    @Override
    public TerritorialOrgConfig getTerritorialOrgConfig(Long id) {
        return territorialOrgConfigRepository.findById(id).orElse(null);
    }

    @Override
    public TerritorialOrgConfig createTerritorialOrgConfig(TerritorialOrgConfig terri) {
        terri.setStatus("CREATED");
        terri.setCreation_date(new Date());
        terri.setLast_update_date(new Date());

        return territorialOrgConfigRepository.save(terri);
    }

    @Override
    public TerritorialOrgConfig updateTerritorialOrgConfig(TerritorialOrgConfig terri) {
        TerritorialOrgConfig terriDB = getTerritorialOrgConfig(terri.getId());
        if(null == terriDB){
            return null;
        }

        terriDB.setName(terri.getName());
        terriDB.setCountryId(terri.getCountryId());
        terriDB.setAttribute1(terri.getAttribute1());
        terriDB.setAttribute2(terri.getAttribute2());
        terriDB.setAttribute3(terri.getAttribute3());
        terriDB.setAttribute4(terri.getAttribute4());
        terriDB.setAttribute5(terri.getAttribute5());
        terriDB.setAttribute6(terri.getAttribute6());
        terriDB.setAttribute7(terri.getAttribute7());
        terriDB.setAttribute8(terri.getAttribute8());
        terriDB.setAttribute9(terri.getAttribute9());
        terriDB.setAttribute10(terri.getAttribute10());

        terriDB.setStatus(terri.getStatus());

        terriDB.setLast_update_by(terri.getLast_update_by());
        terriDB.setLast_update_date(new Date());

        return territorialOrgConfigRepository.save(terriDB);
    }

    @Override
    public Boolean deleteTerritorialOrgConfig(Long id) {
        TerritorialOrgConfig terriDB = getTerritorialOrgConfig(id);
        if(null == terriDB){
            return false;
        }

        territorialOrgConfigRepository.deleteById(id);
        return true;
    }

    @Override
    public TerritorialOrgConfig findByName(String name) {
        return territorialOrgConfigRepository.findByName(name);
    }

}
