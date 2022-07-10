package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TerritorialOrgTwo;

public interface TerritorialOrgTwoRepository extends JpaRepository<TerritorialOrgTwo, Long> {
    public TerritorialOrgTwo findByTerritorialOrgFirstIdAndName(Long territorialOrgFirstId, String name);
}
