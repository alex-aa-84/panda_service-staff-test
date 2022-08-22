package wwf.org.staff.service;

import wwf.org.staff.entity.TerritorialOrgConfig;
import wwf.org.staff.entity.TerritorialOrgFive;
import wwf.org.staff.entity.TerritorialOrgFour;

import java.util.List;

public interface TerritorialOrgFiveService {
    public List<TerritorialOrgFive> listAllTerritorialOrgFive();
    public TerritorialOrgFive getTerritorialOrgFive(Long id);

    public TerritorialOrgFive createTerritorialOrgFive(TerritorialOrgFive territorialOrgFive);
    public TerritorialOrgFive updateTerritorialOrgFive(TerritorialOrgFive territorialOrgFive);
    public Boolean deleteTerritorialOrgFive(Long id);
    public TerritorialOrgFive findByTerritorialOrgFourIdAndName(Long territorialOrgFourId, String name);
    public List<TerritorialOrgFive> findByTerritorialOrgConfig(TerritorialOrgConfig territorialOrgConfig);
    public List<TerritorialOrgFive> findByTerritorialOrgFour(TerritorialOrgFour territorialOrgFour);
}
