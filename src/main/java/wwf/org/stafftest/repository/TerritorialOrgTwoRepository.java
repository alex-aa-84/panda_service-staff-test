package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.TerritorialOrgFirst;
import wwf.org.stafftest.entity.TerritorialOrgTwo;

public interface TerritorialOrgTwoRepository extends JpaRepository<TerritorialOrgTwo, Long> {
    //public TerritorialOrgTwo findByTerritorialOrgFirstIdAndName(Long territorialOrgFirstId, String name);
}
