package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.JobSetting;

import java.util.List;

public interface JobSettingService {
    public List<JobSetting> listAllJobSetting();
    public JobSetting getJobSetting(Long id);

    public JobSetting createJobSetting(JobSetting jobSetting);
    public JobSetting updateJobSetting(JobSetting jobSetting);
    public Boolean deleteJobSetting(Long id);

    public JobSetting findByCode(String code);
}
