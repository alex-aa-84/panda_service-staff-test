package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wwf.org.staff.entity.TerritorialOrgConfig;
import wwf.org.staff.entity.TerritorialOrgFive;
import wwf.org.staff.entity.TerritorialOrgFour;

public interface TerritorialOrgFiveRepository extends JpaRepository<TerritorialOrgFive, Long> {
    public TerritorialOrgFive findByTerritorialOrgFourIdAndName(Long territorialOrgFourId, String name);
    public List<TerritorialOrgFive> findByTerritorialOrgConfig(TerritorialOrgConfig territorialOrgConfig);
    public List<TerritorialOrgFive> findByTerritorialOrgFour(TerritorialOrgFour territorialOrgFour);
}
