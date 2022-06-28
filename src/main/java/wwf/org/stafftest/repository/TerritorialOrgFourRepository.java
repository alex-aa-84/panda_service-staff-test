package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.TerritorialOrgFour;
import wwf.org.stafftest.entity.TerritorialOrgThree;
import wwf.org.stafftest.entity.TerritorialOrgTwo;

public interface TerritorialOrgFourRepository extends JpaRepository<TerritorialOrgFour, Long> {
    //public TerritorialOrgFour findByTerritorialOrgThreeIdAndName(Long territorialOrgThreeId, String name);

}
