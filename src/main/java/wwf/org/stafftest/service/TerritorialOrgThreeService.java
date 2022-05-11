package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.TerritorialOrgThree;

import java.util.List;

public interface TerritorialOrgThreeService {
    public List<TerritorialOrgThree> listAllTerritorialOrgThree();
    public TerritorialOrgThree getTerritorialOrgThree(Long id);

    public TerritorialOrgThree createTerritorialOrgThree(TerritorialOrgThree territorialOrgThree, Long userId);
    public TerritorialOrgThree updateTerritorialOrgThree(TerritorialOrgThree territorialOrgThree, Long userId);
    public TerritorialOrgThree deleteTerritorialOrgThree(Long id, Long userId);
}
