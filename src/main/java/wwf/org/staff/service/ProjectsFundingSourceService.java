package wwf.org.staff.service;

import wwf.org.staff.entity.FundingSource;
import wwf.org.staff.entity.Projects;
import wwf.org.staff.entity.ProjectsFundingSource;

import java.util.List;

public interface ProjectsFundingSourceService {

    public List<ProjectsFundingSource> listAllProjectsFundingSource();
    public ProjectsFundingSource getProjectsFundingSource(Long id);

    public ProjectsFundingSource createProjectsFundingSource(ProjectsFundingSource projectsFundingSource);
    public ProjectsFundingSource updateProjectsFundingSource(ProjectsFundingSource projectsFundingSource);
    public Boolean deleteProjectsFundingSource(Long id);

    public ProjectsFundingSource findByProjectsIdAndFundingSourceId(Long projectsId, Long fundingSourceId);
    public List<ProjectsFundingSource> findByProjectsId(Long projectsId);
}
