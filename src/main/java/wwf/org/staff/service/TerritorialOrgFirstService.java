package wwf.org.staff.service;

import wwf.org.staff.entity.TerritorialOrgFirst;

import java.util.List;

public interface TerritorialOrgFirstService {
    public List<TerritorialOrgFirst> listAllTerritorialOrgFirst();
    public TerritorialOrgFirst getTerritorialOrgFirst(Long id);

    public TerritorialOrgFirst createTerritorialOrgFirst(TerritorialOrgFirst territorialOrgFirst);
    public TerritorialOrgFirst updateTerritorialOrgFirst(TerritorialOrgFirst territorialOrgFirst);
    public Boolean deleteTerritorialOrgFirst(Long id);
    public TerritorialOrgFirst findByCountryIdAndName(Long countryId, String name);
}
