package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wwf.org.staff.entity.TerritorialOrgConfig;
import wwf.org.staff.entity.TerritorialOrgFour;
import wwf.org.staff.entity.TerritorialOrgThree;

public interface TerritorialOrgFourRepository extends JpaRepository<TerritorialOrgFour, Long> {
    public TerritorialOrgFour findByTerritorialOrgThreeIdAndName(Long territorialOrgThreeId, String name);
    public List<TerritorialOrgFour> findByTerritorialOrgConfig(TerritorialOrgConfig territorialOrgConfig);
    public List<TerritorialOrgFour> findByTerritorialOrgThree(TerritorialOrgThree territorialOrgThree);
}
