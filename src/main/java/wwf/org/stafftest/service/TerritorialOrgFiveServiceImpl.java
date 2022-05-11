package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.TerritorialOrgFirst;
import wwf.org.stafftest.entity.TerritorialOrgFive;
import wwf.org.stafftest.repository.TerritorialOrgFiveRepository;

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
    public TerritorialOrgFive createTerritorialOrgFive(TerritorialOrgFive territorialOrgFive, Long userId) {
        territorialOrgFive.setStatus("CREATED");
        territorialOrgFive.setCreate_by(userId);
        territorialOrgFive.setCreation_date(new Date());
        territorialOrgFive.setLast_update_by(userId);
        territorialOrgFive.setLast_update_date(new Date());

        return territorialOrgFiveRepository.save(territorialOrgFive);
    }

    @Override
    public TerritorialOrgFive updateTerritorialOrgFive(TerritorialOrgFive territorialOrgFive, Long userId) {
        TerritorialOrgFive territorialOrgFiveDB = getTerritorialOrgFive(territorialOrgFive.getId());
        if(null == territorialOrgFiveDB){
            return null;
        }

        territorialOrgFive.setLast_update_by(userId);
        territorialOrgFive.setLast_update_date(new Date());

        return territorialOrgFiveRepository.save(territorialOrgFive);
    }

    @Override
    public TerritorialOrgFive deleteTerritorialOrgFive(Long id, Long userId) {
        TerritorialOrgFive territorialOrgFiveDB = getTerritorialOrgFive(id);
        if(null == territorialOrgFiveDB){
            return null;
        }

        territorialOrgFiveDB.setStatus("DELETED");
        territorialOrgFiveDB.setLast_update_by(userId);
        territorialOrgFiveDB.setLast_update_date(new Date());

        return territorialOrgFiveRepository.save(territorialOrgFiveDB);
    }
}
