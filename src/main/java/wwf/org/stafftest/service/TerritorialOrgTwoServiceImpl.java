package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.TerritorialOrgFirst;
import wwf.org.stafftest.entity.TerritorialOrgTwo;
import wwf.org.stafftest.repository.TerritorialOrgTwoRepository;

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
    public TerritorialOrgTwo createTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo, Long userId) {
        territorialOrgTwo.setStatus("CREATED");
        territorialOrgTwo.setCreate_by(userId);
        territorialOrgTwo.setCreation_date(new Date());
        territorialOrgTwo.setLast_update_by(userId);
        territorialOrgTwo.setLast_update_date(new Date());

        return territorialOrgTwoRepository.save(territorialOrgTwo);
    }

    @Override
    public TerritorialOrgTwo updateTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo, Long userId) {
        TerritorialOrgTwo territorialOrgTwoDB = getTerritorialOrgTwo(territorialOrgTwo.getId());
        if(null == territorialOrgTwoDB){
            return null;
        }

        territorialOrgTwo.setLast_update_by(userId);
        territorialOrgTwo.setLast_update_date(new Date());

        return territorialOrgTwoRepository.save(territorialOrgTwo);
    }

    @Override
    public TerritorialOrgTwo deleteTerritorialOrgTwo(Long id, Long userId) {
        TerritorialOrgTwo territorialOrgTwoDB = getTerritorialOrgTwo(id);
        if(null == territorialOrgTwoDB){
            return null;
        }

        territorialOrgTwoDB.setStatus("DELETED");
        territorialOrgTwoDB.setLast_update_by(userId);
        territorialOrgTwoDB.setLast_update_date(new Date());

        return territorialOrgTwoRepository.save(territorialOrgTwoDB);
    }
}
