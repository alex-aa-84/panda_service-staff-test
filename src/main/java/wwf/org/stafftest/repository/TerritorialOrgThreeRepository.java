package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.TerritorialOrgThree;
import wwf.org.stafftest.entity.TerritorialOrgTwo;

public interface TerritorialOrgThreeRepository extends JpaRepository<TerritorialOrgThree, Long> {
    public TerritorialOrgThree findByTerritorialOrgTwoAndName(TerritorialOrgTwo territorialOrgTwo, String name);
}
