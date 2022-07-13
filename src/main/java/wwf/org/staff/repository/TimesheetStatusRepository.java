package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetStatus;

public interface TimesheetStatusRepository extends JpaRepository<TimesheetStatus, Long> {

    public TimesheetStatus findByName(String name);
}
