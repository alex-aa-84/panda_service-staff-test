package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetType;
import wwf.org.staff.entity.TimesheetVersion;

public interface TimesheetVersionRepository extends JpaRepository<TimesheetVersion, Long> {

    public TimesheetVersion findByName(String name);

}
