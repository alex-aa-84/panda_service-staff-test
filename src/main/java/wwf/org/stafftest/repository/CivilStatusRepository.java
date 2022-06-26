package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.CivilStatus;

public interface CivilStatusRepository extends JpaRepository<CivilStatus, Long> {

    public CivilStatus findByCivilStatus(String civilStatus);
}
