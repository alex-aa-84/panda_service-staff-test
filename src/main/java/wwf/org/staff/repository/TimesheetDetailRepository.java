package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetDetails;

public interface TimesheetDetailRepository extends JpaRepository<TimesheetDetails, Long> {

}
