package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TerritorialOrgThree;

public interface TerritorialOrgThreeRepository extends JpaRepository<TerritorialOrgThree, Long> {
    public TerritorialOrgThree findByTerritorialOrgTwoIdAndName(Long territorialOrgTwoId, String name);
}
