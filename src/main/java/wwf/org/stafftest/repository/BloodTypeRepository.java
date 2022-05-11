package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.BloodType;

public interface BloodTypeRepository extends JpaRepository<BloodType, Long> {
}
