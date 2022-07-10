package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Family;

public interface FamilyRepository extends JpaRepository<Family, Long> {
}
