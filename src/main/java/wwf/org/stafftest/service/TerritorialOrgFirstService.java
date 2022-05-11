package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.TerritorialOrgFirst;

import java.util.List;

public interface TerritorialOrgFirstService {
    public List<TerritorialOrgFirst> listAllTerritorialOrgFirst();
    public TerritorialOrgFirst getTerritorialOrgFirst(Long id);

    public TerritorialOrgFirst createTerritorialOrgFirst(TerritorialOrgFirst territorialOrgFirst, Long userId);
    public TerritorialOrgFirst updateTerritorialOrgFirst(TerritorialOrgFirst territorialOrgFirst, Long userId);
    public TerritorialOrgFirst deleteTerritorialOrgFirst(Long id, Long userId);
}
