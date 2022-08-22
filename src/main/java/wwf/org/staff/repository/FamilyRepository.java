package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Family;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    public List<Family> findByUserId(Long id);
}
