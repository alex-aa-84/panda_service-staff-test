package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.JobSetting;

public interface JobSettingRepository extends JpaRepository<JobSetting, Long> {
    public JobSetting findByCode(String code);
    public JobSetting findByUserId(Long id);
}
