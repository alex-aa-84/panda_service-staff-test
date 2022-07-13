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
    public TerritorialOrgConfig createTerritorialOrgConfig(TerritorialOrgConfig relationship) {
        relationship.setStatus("CREATED");
        relationship.setCreation_date(new Date());
        relationship.setLast_update_date(new Date());

        return territorialOrgConfigRepository.save(relationship);
    }

    @Override
    public TerritorialOrgConfig updateTerritorialOrgConfig(TerritorialOrgConfig relationship) {
        TerritorialOrgConfig relationshipDB = getTerritorialOrgConfig(relationship.getId());
        if(null == relationshipDB){
            return null;
        }

        relationshipDB.setName(relationship.getName());

        relationshipDB.setAttribute1(relationship.getAttribute1());
        relationshipDB.setAttribute2(relationship.getAttribute2());
        relationshipDB.setAttribute3(relationship.getAttribute3());
        relationshipDB.setAttribute4(relationship.getAttribute4());
        relationshipDB.setAttribute5(relationship.getAttribute5());
        relationshipDB.setAttribute6(relationship.getAttribute6());
        relationshipDB.setAttribute7(relationship.getAttribute7());
        relationshipDB.setAttribute8(relationship.getAttribute8());
        relationshipDB.setAttribute9(relationship.getAttribute9());
        relationshipDB.setAttribute10(relationship.getAttribute10());

        relationshipDB.setStatus(relationship.getStatus());

        relationshipDB.setLast_update_by(relationship.getLast_update_by());
        relationshipDB.setLast_update_date(new Date());

        return territorialOrgConfigRepository.save(relationshipDB);
    }

    @Override
    public Boolean deleteTerritorialOrgConfig(Long id) {
        TerritorialOrgConfig relationshipDB = getTerritorialOrgConfig(id);
        if(null == relationshipDB){
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
