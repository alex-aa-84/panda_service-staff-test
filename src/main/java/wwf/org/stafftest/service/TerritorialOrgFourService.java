package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.TerritorialOrgFour;

import java.util.List;

public interface TerritorialOrgFourService {
    public List<TerritorialOrgFour> listAllTerritorialOrgFour();
    public TerritorialOrgFour getTerritorialOrgFour(Long id);

    public TerritorialOrgFour createTerritorialOrgFour(TerritorialOrgFour territorialOrgFour, Long userId);
    public TerritorialOrgFour updateTerritorialOrgFour(TerritorialOrgFour territorialOrgFour, Long userId);
    public TerritorialOrgFour deleteTerritorialOrgFour(Long id, Long userId);
}
