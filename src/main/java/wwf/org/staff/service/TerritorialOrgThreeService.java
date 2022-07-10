package wwf.org.staff.service;

import wwf.org.staff.entity.TerritorialOrgThree;
import wwf.org.staff.entity.TerritorialOrgTwo;

import java.util.List;

public interface TerritorialOrgThreeService {
    public List<TerritorialOrgThree> listAllTerritorialOrgThree();
    public TerritorialOrgThree getTerritorialOrgThree(Long id);

    public TerritorialOrgThree createTerritorialOrgThree(TerritorialOrgThree territorialOrgThree);
    public TerritorialOrgThree updateTerritorialOrgThree(TerritorialOrgThree territorialOrgThree);
    public Boolean deleteTerritorialOrgThree(Long id);
    public TerritorialOrgThree findByTerritorialOrgTwoIdAndName(TerritorialOrgTwo territorialOrgTwo, String name);
}
