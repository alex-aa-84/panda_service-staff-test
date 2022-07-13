package wwf.org.staff.service;

import wwf.org.staff.entity.TerritorialOrgFirst;
import wwf.org.staff.entity.TerritorialOrgTwo;

import java.util.List;

public interface TerritorialOrgTwoService {
    public List<TerritorialOrgTwo> listAllTerritorialOrgTwo();
    public TerritorialOrgTwo getTerritorialOrgTwo(Long id);

    public TerritorialOrgTwo createTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo);
    public TerritorialOrgTwo updateTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo);
    public Boolean deleteTerritorialOrgTwo(Long id);
    public TerritorialOrgTwo findByTerritorialOrgFirstIdAndName(Long territorialOrgFirstId, String name);
}
