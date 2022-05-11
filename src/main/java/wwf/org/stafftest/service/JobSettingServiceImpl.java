package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.JobSetting;
import wwf.org.stafftest.repository.JobSettingRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobSettingServiceImpl implements JobSettingService {

    @Autowired
    private JobSettingRepository jobSettingRepository;

    @Override
    public List<JobSetting> listAllJobSetting() {
        return jobSettingRepository.findAll();
    }

    @Override
    public JobSetting getJobSetting(Long id) {
        return jobSettingRepository.findById(id).orElse(null);
    }

    @Override
    public JobSetting createJobSetting(JobSetting jobSetting, Long userId) {
        jobSetting.setStatus("CREATED");
        jobSetting.setCreate_by(userId);
        jobSetting.setCreation_date(new Date());
        jobSetting.setLast_update_by(userId);
        jobSetting.setLast_update_date(new Date());

        return jobSettingRepository.save(jobSetting);
    }

    @Override
    public JobSetting updateJobSetting(JobSetting jobSetting, Long userId) {
        JobSetting jobSettingDB = getJobSetting(jobSetting.getId());
        if(null == jobSettingDB){
            return null;
        }

        jobSetting.setLast_update_by(userId);
        jobSetting.setLast_update_date(new Date());

        return jobSettingRepository.save(jobSetting);
    }

    @Override
    public JobSetting deleteJobSetting(Long id, Long userId) {
        JobSetting jobSettingDB = getJobSetting(id);
        if(null == jobSettingDB){
            return null;
        }

        jobSettingDB.setStatus("DELETED");
        jobSettingDB.setLast_update_by(userId);
        jobSettingDB.setLast_update_date(new Date());

        return jobSettingRepository.save(jobSettingDB);
    }
}
