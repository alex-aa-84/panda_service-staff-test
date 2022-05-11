package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.JobSetting;

import java.util.List;

public interface JobSettingService {
    public List<JobSetting> listAllJobSetting();
    public JobSetting getJobSetting(Long id);

    public JobSetting createJobSetting(JobSetting jobSetting, Long userId);
    public JobSetting updateJobSetting(JobSetting jobSetting, Long userId);
    public JobSetting deleteJobSetting(Long id, Long userId);
}
