package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {

    public Projects findByFundingSourceIdAndNumberProject(Long fundingSourceId, String numberProject);
}
