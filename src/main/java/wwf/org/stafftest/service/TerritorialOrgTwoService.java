package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.TerritorialOrgTwo;

import java.util.List;

public interface TerritorialOrgTwoService {
    public List<TerritorialOrgTwo> listAllTerritorialOrgTwo();
    public TerritorialOrgTwo getTerritorialOrgTwo(Long id);

    public TerritorialOrgTwo createTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo, Long userId);
    public TerritorialOrgTwo updateTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo, Long userId);
    public TerritorialOrgTwo deleteTerritorialOrgTwo(Long id, Long userId);
}
