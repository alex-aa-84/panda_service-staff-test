package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import wwf.org.staff.entity.ProjectsSheets;
import wwf.org.staff.entity.TimesheetCycle;

import java.util.List;

public interface ProjectsSheetsRepository extends JpaRepository<ProjectsSheets, Long> {

    public ProjectsSheets findByFiscalYearAndMonthFiscalYearAndUserIdAndProjectsFundingSourceId(Integer year, Integer month, Long user, Long projectsFundingSourceId);

    public List<ProjectsSheets> findByFiscalYearAndMonthFiscalYear(Integer year, Integer month);

    @Query("SELECT p FROM ProjectsSheets p where p.userId = ?1 and p.timesheetCycle = ?2 and p.status != 'INACTIVE'")
    public List<ProjectsSheets> findActiveUserCycle(Long userId, TimesheetCycle timesheetCycle);

}
