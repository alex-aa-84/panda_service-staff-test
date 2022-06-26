package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.TerritorialOrgFour;
import wwf.org.stafftest.entity.TerritorialOrgThree;

import java.util.List;

public interface TerritorialOrgFourService {
    public List<TerritorialOrgFour> listAllTerritorialOrgFour();
    public TerritorialOrgFour getTerritorialOrgFour(Long id);

    public TerritorialOrgFour createTerritorialOrgFour(TerritorialOrgFour territorialOrgFour);
    public TerritorialOrgFour updateTerritorialOrgFour(TerritorialOrgFour territorialOrgFour);
    public Boolean deleteTerritorialOrgFour(Long id);
    public TerritorialOrgFour findByTerritorialOrgThreeAndName(TerritorialOrgThree territorialOrgThree, String name);
}
