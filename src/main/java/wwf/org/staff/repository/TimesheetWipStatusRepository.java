package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetWipStatus;

public interface TimesheetWipStatusRepository extends JpaRepository<TimesheetWipStatus, Long> {

    public TimesheetWipStatus findByTimesheetWipStatus(String val);
}
