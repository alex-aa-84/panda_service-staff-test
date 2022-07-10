package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TerritorialOrgFirst;

public interface TerritorialOrgFirstRepository extends JpaRepository<TerritorialOrgFirst, Long> {
    public TerritorialOrgFirst findByCountryIdAndName(Long countryId, String name);
}
