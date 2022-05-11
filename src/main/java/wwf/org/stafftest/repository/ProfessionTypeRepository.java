package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.ProfessionType;

public interface ProfessionTypeRepository extends JpaRepository<ProfessionType, Long> {
}
