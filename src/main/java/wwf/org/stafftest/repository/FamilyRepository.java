package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.Family;

public interface FamilyRepository extends JpaRepository<Family, Long> {
}