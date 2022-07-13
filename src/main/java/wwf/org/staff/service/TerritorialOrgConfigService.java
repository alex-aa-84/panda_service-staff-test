package wwf.org.staff.service;

import wwf.org.staff.entity.TerritorialOrgConfig;

import java.util.List;

public interface TerritorialOrgConfigService {
    public List<TerritorialOrgConfig> listAllTerritorialOrgConfig();
    public TerritorialOrgConfig getTerritorialOrgConfig(Long id);

    public TerritorialOrgConfig createTerritorialOrgConfig(TerritorialOrgConfig territorialOrgConfig);
    public TerritorialOrgConfig updateTerritorialOrgConfig(TerritorialOrgConfig territorialOrgConfig);
    public Boolean deleteTerritorialOrgConfig(Long id);

    public TerritorialOrgConfig findByName(String name);
}
