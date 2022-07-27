package wwf.org.staff.service;

import wwf.org.staff.entity.ProjectsSheets;
import wwf.org.staff.entity.TimesheetCycle;

import java.util.List;

public interface ProjectsSheetsService {
    public List<ProjectsSheets> listAllProjectsSheets();

    public ProjectsSheets getProjectsSheets(Long id);

    public ProjectsSheets createProjectsSheets(ProjectsSheets value);
    public ProjectsSheets updateProjectsSheets(ProjectsSheets value);
    public Boolean deleteProjectsSheets(Long id);

    public ProjectsSheets findByFiscalYearAndMonthFiscalYearAndUserIdAndProjectsFundingSourceId(Integer year, Integer month, Long user, Long projectsFundingSourceId);

    public List<ProjectsSheets> findByFiscalYearAndMonthFiscalYear(Integer year, Integer month);

    public List<ProjectsSheets> findActiveUserCycle(Long userId, TimesheetCycle timesheetCycle);
}
