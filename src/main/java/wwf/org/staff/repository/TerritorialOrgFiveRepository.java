package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TerritorialOrgFive;

public interface TerritorialOrgFiveRepository extends JpaRepository<TerritorialOrgFive, Long> {
    public TerritorialOrgFive findByTerritorialOrgFourIdAndName(Long territorialOrgFourId, String name);
}
