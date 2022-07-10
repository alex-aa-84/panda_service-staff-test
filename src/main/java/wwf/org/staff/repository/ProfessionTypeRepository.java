package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.ProfessionType;

public interface ProfessionTypeRepository extends JpaRepository<ProfessionType, Long> {
    public ProfessionType findByProfessionType(String professionType);
}
