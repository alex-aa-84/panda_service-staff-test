package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wwf.org.staff.entity.TerritorialOrgConfig;
import wwf.org.staff.entity.TerritorialOrgFirst;
import wwf.org.staff.entity.TerritorialOrgTwo;

public interface TerritorialOrgTwoRepository extends JpaRepository<TerritorialOrgTwo, Long> {
    public TerritorialOrgTwo findByTerritorialOrgFirstIdAndName(Long territorialOrgFirstId, String name);
    public List<TerritorialOrgTwo> findByTerritorialOrgConfig(TerritorialOrgConfig territorialOrgConfig);
    public List<TerritorialOrgTwo> findByTerritorialOrgFirst(TerritorialOrgFirst territorialOrgFirst);
}
