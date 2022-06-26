package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.TerritorialOrgFive;
import wwf.org.stafftest.entity.TerritorialOrgFour;
import wwf.org.stafftest.entity.TerritorialOrgThree;

public interface TerritorialOrgFiveRepository extends JpaRepository<TerritorialOrgFive, Long> {
    public TerritorialOrgFive findByTerritorialOrgFourAndName(TerritorialOrgFour territorialOrgFour, String name);
}
