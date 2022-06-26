package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.JobTittle;

public interface JobTitleRepository extends JpaRepository<JobTittle, Long> {
    public JobTittle findByJobTitle(String jobTitle);
}
