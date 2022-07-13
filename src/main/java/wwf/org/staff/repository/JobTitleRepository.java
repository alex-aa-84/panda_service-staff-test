package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.JobTittle;

public interface JobTitleRepository extends JpaRepository<JobTittle, Long> {
    public JobTittle findByName(String name);
}
