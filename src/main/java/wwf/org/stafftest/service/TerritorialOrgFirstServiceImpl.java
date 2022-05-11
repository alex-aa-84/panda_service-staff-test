package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.TerritorialOrgFirst;
import wwf.org.stafftest.repository.TerritorialOrgFirstRepository;

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
    public TerritorialOrgFirst createTerritorialOrgFirst(TerritorialOrgFirst territorialOrgFirst, Long userId) {
        territorialOrgFirst.setStatus("CREATED");
        territorialOrgFirst.setCreate_by(userId);
        territorialOrgFirst.setCreation_date(new Date());
        territorialOrgFirst.setLast_update_by(userId);
        territorialOrgFirst.setLast_update_date(new Date());

        return territorialOrgFirstRepository.save(territorialOrgFirst);
    }

    @Override
    public TerritorialOrgFirst updateTerritorialOrgFirst(TerritorialOrgFirst territorialOrgFirst, Long userId) {
        TerritorialOrgFirst territorialOrgFirstDB = getTerritorialOrgFirst(territorialOrgFirst.getId());
        if(null == territorialOrgFirstDB){
            return null;
        }

        territorialOrgFirst.setLast_update_by(userId);
        territorialOrgFirst.setLast_update_date(new Date());

        return territorialOrgFirstRepository.save(territorialOrgFirst);
    }

    @Override
    public TerritorialOrgFirst deleteTerritorialOrgFirst(Long id, Long userId) {
        TerritorialOrgFirst territorialOrgFirstDB = getTerritorialOrgFirst(id);
        if(null == territorialOrgFirstDB){
            return null;
        }

        territorialOrgFirstDB.setStatus("DELETED");
        territorialOrgFirstDB.setLast_update_by(userId);
        territorialOrgFirstDB.setLast_update_date(new Date());

        return territorialOrgFirstRepository.save(territorialOrgFirstDB);
    }
}
