package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.JobTittle;
import wwf.org.staff.entity.TerritorialOrgConfig;

public interface TerritorialOrgConfigRepository extends JpaRepository<TerritorialOrgConfig, Long> {

    public TerritorialOrgConfig findByName(String name);

}
