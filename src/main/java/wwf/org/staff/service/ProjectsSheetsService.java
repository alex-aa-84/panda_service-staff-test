package wwf.org.staff.service;

import wwf.org.staff.entity.Projects;
import wwf.org.staff.entity.ProjectsSheets;

import java.util.List;

public interface ProjectsSheetsService {
    public List<ProjectsSheets> listAllProjectsSheets();

    public ProjectsSheets getProjectsSheets(Long id);

    public ProjectsSheets createProjectsSheets(ProjectsSheets value);
    public ProjectsSheets updateProjectsSheets(ProjectsSheets value);
    public Boolean deleteProjectsSheets(Long id);

    public ProjectsSheets findByFiscalYearAndMonthFiscalYearAndUserIdAndProjectsId(Integer year, Integer month, Long user, Long projectsId);
}
