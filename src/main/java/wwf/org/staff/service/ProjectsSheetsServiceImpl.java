package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.Projects;
import wwf.org.staff.entity.ProjectsSheets;
import wwf.org.staff.repository.ProjectsSheetsRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectsSheetsServiceImpl implements ProjectsSheetsService{


    @Autowired
    private ProjectsSheetsRepository repository;


    @Override
    public List<ProjectsSheets> listAllProjectsSheets() {
        return repository.findAll();
    }

    @Override
    public ProjectsSheets getProjectsSheets(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ProjectsSheets createProjectsSheets(ProjectsSheets value) {
        value.setStatus("CREATED");
        value.setCreation_date(new Date());
        value.setLast_update_date(new Date());

        return repository.save(value);
    }

    @Override
    public ProjectsSheets updateProjectsSheets(ProjectsSheets value) {
        ProjectsSheets bd = getProjectsSheets(value.getId());
        if(null == bd){
            return null;
        }

        bd.setTimesheetVersionId(value.getTimesheetVersionId());
        bd.setFiscalYear(value.getFiscalYear());
        bd.setMonthFiscalYear(value.getMonthFiscalYear());
        bd.setUserId(value.getUserId());
        bd.setProjects(value.getProjects());
        bd.setBudgetHours(value.getBudgetHours());
        bd.setAvailableHours(value.getAvailableHours());
        bd.setUsedHours(value.getUsedHours());
        bd.setTimesheetCycle(value.getTimesheetCycle());

        bd.setDescription(value.getDescription());

        bd.setAttribute1(value.getAttribute1());
        bd.setAttribute2(value.getAttribute2());
        bd.setAttribute3(value.getAttribute3());
        bd.setAttribute4(value.getAttribute4());
        bd.setAttribute5(value.getAttribute5());
        bd.setAttribute6(value.getAttribute6());
        bd.setAttribute7(value.getAttribute7());
        bd.setAttribute8(value.getAttribute8());
        bd.setAttribute9(value.getAttribute9());
        bd.setAttribute10(value.getAttribute10());

        bd.setStatus(value.getStatus());

        bd.setLast_update_by(value.getLast_update_by());
        bd.setLast_update_date(new Date());

        return repository.save(bd);
    }

    @Override
    public Boolean deleteProjectsSheets(Long id) {
        ProjectsSheets bd = getProjectsSheets(id);
        if(null == bd){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public ProjectsSheets findByFiscalYearAndMonthFiscalYearAndUserIdAndProjectsId(Integer year, Integer month, Long user, Long projectsId) {
        return repository.findByFiscalYearAndMonthFiscalYearAndUserIdAndProjectsId(year, month, user, projectsId);
    }


}
