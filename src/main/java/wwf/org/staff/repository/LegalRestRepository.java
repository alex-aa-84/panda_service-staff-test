package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.LegalRest;

import java.util.Date;

public interface LegalRestRepository extends JpaRepository<LegalRest, Long> {
    public LegalRest findByUserIdAndStartDateAndEndDate(Long userId, Date startDate, Date endDate);
}
