package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetHeader;

public interface TimesheetHeaderRepository extends JpaRepository<TimesheetHeader, Long> {
    
}
