package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.TerritorialOrgFive;

import java.util.List;

public interface TerritorialOrgFiveService {
    public List<TerritorialOrgFive> listAllTerritorialOrgFive();
    public TerritorialOrgFive getTerritorialOrgFive(Long id);

    public TerritorialOrgFive createTerritorialOrgFive(TerritorialOrgFive territorialOrgFive, Long userId);
    public TerritorialOrgFive updateTerritorialOrgFive(TerritorialOrgFive territorialOrgFive, Long userId);
    public TerritorialOrgFive deleteTerritorialOrgFive(Long id, Long userId);
}
