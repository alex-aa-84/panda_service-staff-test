package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.JobSetting;

public interface JobSettingRepository extends JpaRepository<JobSetting, Long> {
    public JobSetting findByCode(String code);
}
