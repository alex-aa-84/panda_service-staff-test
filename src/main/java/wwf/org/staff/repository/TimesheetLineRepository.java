package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetLines;

public interface TimesheetLineRepository extends JpaRepository<TimesheetLines, Long> {
}
