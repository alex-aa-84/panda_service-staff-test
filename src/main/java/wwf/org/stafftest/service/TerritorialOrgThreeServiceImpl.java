package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.TerritorialOrgFirst;
import wwf.org.stafftest.entity.TerritorialOrgThree;
import wwf.org.stafftest.repository.TerritorialOrgThreeRepository;

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
    public TerritorialOrgThree createTerritorialOrgThree(TerritorialOrgThree territorialOrgThree, Long userId) {
        territorialOrgThree.setStatus("CREATED");
        territorialOrgThree.setCreate_by(userId);
        territorialOrgThree.setCreation_date(new Date());
        territorialOrgThree.setLast_update_by(userId);
        territorialOrgThree.setLast_update_date(new Date());

        return territorialOrgThreeRepository.save(territorialOrgThree);
    }

    @Override
    public TerritorialOrgThree updateTerritorialOrgThree(TerritorialOrgThree territorialOrgThree, Long userId) {
        TerritorialOrgThree territorialOrgThreeDB = getTerritorialOrgThree(territorialOrgThree.getId());
        if(null == territorialOrgThreeDB){
            return null;
        }

        territorialOrgThree.setLast_update_by(userId);
        territorialOrgThree.setLast_update_date(new Date());

        return territorialOrgThreeRepository.save(territorialOrgThree);
    }

    @Override
    public TerritorialOrgThree deleteTerritorialOrgThree(Long id, Long userId) {
        TerritorialOrgThree territorialOrgThreeDB = getTerritorialOrgThree(id);
        if(null == territorialOrgThreeDB){
            return null;
        }

        territorialOrgThreeDB.setStatus("DELETED");
        territorialOrgThreeDB.setLast_update_by(userId);
        territorialOrgThreeDB.setLast_update_date(new Date());

        return territorialOrgThreeRepository.save(territorialOrgThreeDB);
    }
}
