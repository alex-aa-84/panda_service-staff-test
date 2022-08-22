package wwf.org.staff.service;

import wwf.org.staff.entity.JobSetting;

import java.util.List;

public interface JobSettingService {
    public List<JobSetting> listAllJobSetting();
    public JobSetting getJobSetting(Long id);

    public JobSetting createJobSetting(JobSetting jobSetting);
    public JobSetting updateJobSetting(JobSetting jobSetting);
    public Boolean deleteJobSetting(Long id);

    public JobSetting findByCode(String code);

    public JobSetting findByUserId(Long id);
}
