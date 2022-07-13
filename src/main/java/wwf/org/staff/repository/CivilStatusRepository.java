package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.CivilStatus;

public interface CivilStatusRepository extends JpaRepository<CivilStatus, Long> {

    public CivilStatus findByName(String name);
}
