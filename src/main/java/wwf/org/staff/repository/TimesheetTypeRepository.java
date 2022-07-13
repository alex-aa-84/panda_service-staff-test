package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetType;

public interface TimesheetTypeRepository extends JpaRepository<TimesheetType, Long> {

    public TimesheetType findByName(String name);
}
