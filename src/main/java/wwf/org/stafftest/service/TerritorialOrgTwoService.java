package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.TerritorialOrgFirst;
import wwf.org.stafftest.entity.TerritorialOrgTwo;

import java.util.List;

public interface TerritorialOrgTwoService {
    public List<TerritorialOrgTwo> listAllTerritorialOrgTwo();
    public TerritorialOrgTwo getTerritorialOrgTwo(Long id);

    public TerritorialOrgTwo createTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo);
    public TerritorialOrgTwo updateTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo);
    public Boolean deleteTerritorialOrgTwo(Long id);
    public TerritorialOrgTwo findByTerritorialOrgFirstIdAndName(TerritorialOrgFirst territorialOrgFirst, String name);
}
