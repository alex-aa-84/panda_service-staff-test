package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.TerritorialOrgFirst;
import wwf.org.stafftest.entity.TerritorialOrgFour;
import wwf.org.stafftest.repository.TerritorialOrgFourRepository;

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
    public TerritorialOrgFour createTerritorialOrgFour(TerritorialOrgFour territorialOrgFour, Long userId) {
        territorialOrgFour.setStatus("CREATED");
        territorialOrgFour.setCreate_by(userId);
        territorialOrgFour.setCreation_date(new Date());
        territorialOrgFour.setLast_update_by(userId);
        territorialOrgFour.setLast_update_date(new Date());

        return territorialOrgFourRepository.save(territorialOrgFour);
    }

    @Override
    public TerritorialOrgFour updateTerritorialOrgFour(TerritorialOrgFour territorialOrgFour, Long userId) {
        TerritorialOrgFour territorialOrgFourDB = getTerritorialOrgFour(territorialOrgFour.getId());
        if(null == territorialOrgFourDB){
            return null;
        }

        territorialOrgFour.setLast_update_by(userId);
        territorialOrgFour.setLast_update_date(new Date());

        return territorialOrgFourRepository.save(territorialOrgFour);
    }

    @Override
    public TerritorialOrgFour deleteTerritorialOrgFour(Long id, Long userId) {
        TerritorialOrgFour territorialOrgFourDB = getTerritorialOrgFour(id);
        if(null == territorialOrgFourDB){
            return null;
        }

        territorialOrgFourDB.setStatus("DELETED");
        territorialOrgFourDB.setLast_update_by(userId);
        territorialOrgFourDB.setLast_update_date(new Date());

        return territorialOrgFourRepository.save(territorialOrgFourDB);
    }
}
