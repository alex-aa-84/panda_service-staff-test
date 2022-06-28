package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.TerritorialOrgFive;
import wwf.org.stafftest.entity.TerritorialOrgFour;

import java.util.List;

public interface TerritorialOrgFiveService {
    public List<TerritorialOrgFive> listAllTerritorialOrgFive();
    public TerritorialOrgFive getTerritorialOrgFive(Long id);

    public TerritorialOrgFive createTerritorialOrgFive(TerritorialOrgFive territorialOrgFive);
    public TerritorialOrgFive updateTerritorialOrgFive(TerritorialOrgFive territorialOrgFive);
    public Boolean deleteTerritorialOrgFive(Long id);
    public TerritorialOrgFive findByTerritorialOrgFourIdAndName(TerritorialOrgFour territorialOrgFour, String name);
}
