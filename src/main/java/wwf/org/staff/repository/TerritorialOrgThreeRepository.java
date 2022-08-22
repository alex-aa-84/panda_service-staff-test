package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wwf.org.staff.entity.TerritorialOrgConfig;
import wwf.org.staff.entity.TerritorialOrgThree;
import wwf.org.staff.entity.TerritorialOrgTwo;

public interface TerritorialOrgThreeRepository extends JpaRepository<TerritorialOrgThree, Long> {
   public TerritorialOrgThree findByTerritorialOrgTwoIdAndName(Long territorialOrgTwoId, String name);
   public List<TerritorialOrgThree> findByTerritorialOrgConfig(TerritorialOrgConfig territorialOrgConfig);
   public List<TerritorialOrgThree> findByTerritorialOrgTwo(TerritorialOrgTwo territorialOrgTwo);
}
