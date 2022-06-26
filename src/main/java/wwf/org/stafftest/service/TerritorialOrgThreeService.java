package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.TerritorialOrgThree;
import wwf.org.stafftest.entity.TerritorialOrgTwo;

import java.util.List;

public interface TerritorialOrgThreeService {
    public List<TerritorialOrgThree> listAllTerritorialOrgThree();
    public TerritorialOrgThree getTerritorialOrgThree(Long id);

    public TerritorialOrgThree createTerritorialOrgThree(TerritorialOrgThree territorialOrgThree);
    public TerritorialOrgThree updateTerritorialOrgThree(TerritorialOrgThree territorialOrgThree);
    public Boolean deleteTerritorialOrgThree(Long id);
    public TerritorialOrgThree findByTerritorialOrgTwoAndName(TerritorialOrgTwo territorialOrgTwo, String name);
}
