package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.FundingSource;
import wwf.org.staff.entity.ProfessionType;
import wwf.org.staff.entity.Projects;
import wwf.org.staff.entity.ProjectsFundingSource;

import java.util.List;

public interface ProjectsFundingSourceRepository extends JpaRepository<ProjectsFundingSource, Long> {

    public ProjectsFundingSource findByProjectsIdAndFundingSourceId(Long projectsId, Long fundingSourceId);

    public List<ProjectsFundingSource> findByProjectsId(Long projectsId);

}
