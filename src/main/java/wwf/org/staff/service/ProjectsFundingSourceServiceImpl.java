package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.FundingSource;
import wwf.org.staff.entity.Projects;
import wwf.org.staff.entity.ProjectsFundingSource;
import wwf.org.staff.repository.ProjectsFundingSourceRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectsFundingSourceServiceImpl implements ProjectsFundingSourceService{

    @Autowired
    private ProjectsFundingSourceRepository service;

    @Override
    public List<ProjectsFundingSource> listAllProjectsFundingSource() {
        return service.findAll();
    }

    @Override
    public ProjectsFundingSource getProjectsFundingSource(Long id) {
        return service.findById(id).orElse(null);
    }

    @Override
    public ProjectsFundingSource createProjectsFundingSource(ProjectsFundingSource projectsFundingSource) {
        projectsFundingSource.setStatus("CREATED");
        projectsFundingSource.setCreation_date(new Date());
        projectsFundingSource.setLast_update_date(new Date());

        return service.save(projectsFundingSource);
    }

    @Override
    public ProjectsFundingSource updateProjectsFundingSource(ProjectsFundingSource projectsFundingSource) {
        ProjectsFundingSource projectsFundingSourceDB = getProjectsFundingSource(projectsFundingSource.getId());
        if(null == projectsFundingSourceDB){
            return null;
        }

        projectsFundingSourceDB.setProjects(projectsFundingSource.getProjects());
        projectsFundingSourceDB.setFundingSource(projectsFundingSource.getFundingSource());
        projectsFundingSourceDB.setDescription(projectsFundingSource.getDescription());

        projectsFundingSourceDB.setAttribute1(projectsFundingSource.getAttribute1());
        projectsFundingSourceDB.setAttribute2(projectsFundingSource.getAttribute2());
        projectsFundingSourceDB.setAttribute3(projectsFundingSource.getAttribute3());
        projectsFundingSourceDB.setAttribute4(projectsFundingSource.getAttribute4());
        projectsFundingSourceDB.setAttribute5(projectsFundingSource.getAttribute5());
        projectsFundingSourceDB.setAttribute6(projectsFundingSource.getAttribute6());
        projectsFundingSourceDB.setAttribute7(projectsFundingSource.getAttribute7());
        projectsFundingSourceDB.setAttribute8(projectsFundingSource.getAttribute8());
        projectsFundingSourceDB.setAttribute9(projectsFundingSource.getAttribute9());
        projectsFundingSourceDB.setAttribute10(projectsFundingSource.getAttribute10());

        projectsFundingSourceDB.setStatus(projectsFundingSource.getStatus());

        projectsFundingSourceDB.setLast_update_by(projectsFundingSource.getLast_update_by());
        projectsFundingSourceDB.setLast_update_date(new Date());

        return service.save(projectsFundingSourceDB);
    }

    @Override
    public Boolean deleteProjectsFundingSource(Long id) {
        ProjectsFundingSource projectsFundingSourceDB = getProjectsFundingSource(id);
        if(null == projectsFundingSourceDB){
            return false;
        }

        service.deleteById(id);
        return true;
    }

    @Override
    public ProjectsFundingSource findByProjectsIdAndFundingSourceId(Long projectsId, Long fundingSourceId) {
        return service.findByProjectsIdAndFundingSourceId(projectsId, fundingSourceId);
    }

    @Override
    public List<ProjectsFundingSource> findByProjectsId(Long projectsId) {
        return service.findByProjectsId(projectsId);
    }
}
