package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TerritorialOrgFour;

public interface TerritorialOrgFourRepository extends JpaRepository<TerritorialOrgFour, Long> {
    public TerritorialOrgFour findByTerritorialOrgThreeIdAndName(Long territorialOrgThreeId, String name);

}
