package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetCycle;

public interface TimesheetCycleRepository extends JpaRepository<TimesheetCycle, Long> {

    public TimesheetCycle findByFiscalYearAndMonthFiscalYear(Integer year, Integer month);
}
