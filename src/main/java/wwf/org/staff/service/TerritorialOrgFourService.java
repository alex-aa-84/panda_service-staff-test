package wwf.org.staff.service;

import wwf.org.staff.entity.TerritorialOrgConfig;
import wwf.org.staff.entity.TerritorialOrgFour;
import wwf.org.staff.entity.TerritorialOrgThree;

import java.util.List;

public interface TerritorialOrgFourService {
    public List<TerritorialOrgFour> listAllTerritorialOrgFour();
    public TerritorialOrgFour getTerritorialOrgFour(Long id);

    public TerritorialOrgFour createTerritorialOrgFour(TerritorialOrgFour territorialOrgFour);
    public TerritorialOrgFour updateTerritorialOrgFour(TerritorialOrgFour territorialOrgFour);
    public Boolean deleteTerritorialOrgFour(Long id);
    public TerritorialOrgFour findByTerritorialOrgThreeIdAndName(Long territorialOrgThreeId, String name);
    public List<TerritorialOrgFour> findByTerritorialOrgConfig(TerritorialOrgConfig territorialOrgConfig);
    public List<TerritorialOrgFour> findByTerritorialOrgThree(TerritorialOrgThree territorialOrgThree);
}
