package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Projects;
import wwf.org.staff.entity.ProjectsSheets;

public interface ProjectsSheetsRepository extends JpaRepository<ProjectsSheets, Long> {

    public ProjectsSheets findByFiscalYearAndMonthFiscalYearAndUserIdAndProjectId(Integer year, Integer month, Long user, Long projectId);

}
