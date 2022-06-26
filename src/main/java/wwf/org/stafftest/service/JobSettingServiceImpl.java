package wwf.org.stafftest.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.JobSetting;
import wwf.org.stafftest.entity.JobTittle;
import wwf.org.stafftest.entity.PermissionHeader;
import wwf.org.stafftest.repository.JobSettingRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    public JobSetting createJobSetting(JobSetting jobSetting) {
        jobSetting.setStatus("CREATED");
        jobSetting.setCreation_date(new Date());
        jobSetting.setLast_update_date(new Date());

        return jobSettingRepository.save(jobSetting);
    }

    @Override
    public JobSetting updateJobSetting(JobSetting jobSetting) {
        JobSetting jobSettingDB = getJobSetting(jobSetting.getId());
        if(null == jobSettingDB){
            return null;
        }

        jobSettingDB.setUserId(jobSetting.getUserId());
        jobSettingDB.setCode(jobSetting.getCode());
        jobSettingDB.setUserIdSupervisor(jobSetting.getUserIdSupervisor());
        jobSettingDB.setPermissionHeader(jobSetting.getPermissionHeader());
        jobSettingDB.setJobTittle(jobSetting.getJobTittle());
        jobSettingDB.setEmploymentStartDate(jobSetting.getEmploymentStartDate());
        jobSettingDB.setEmploymentEndDate(jobSetting.getEmploymentEndDate());
        jobSettingDB.setWorkload(jobSetting.getWorkload());
        jobSettingDB.setFlexible(jobSetting.getFlexible());
        jobSettingDB.setObservation(jobSetting.getObservation());

        jobSettingDB.setAttribute1(jobSetting.getAttribute1());
        jobSettingDB.setAttribute2(jobSetting.getAttribute2());
        jobSettingDB.setAttribute3(jobSetting.getAttribute3());
        jobSettingDB.setAttribute4(jobSetting.getAttribute4());
        jobSettingDB.setAttribute5(jobSetting.getAttribute5());
        jobSettingDB.setAttribute6(jobSetting.getAttribute6());
        jobSettingDB.setAttribute7(jobSetting.getAttribute7());
        jobSettingDB.setAttribute8(jobSetting.getAttribute8());
        jobSettingDB.setAttribute9(jobSetting.getAttribute9());
        jobSettingDB.setAttribute10(jobSetting.getAttribute10());

        jobSettingDB.setStatus(jobSetting.getStatus());

        jobSettingDB.setLast_update_by(jobSetting.getLast_update_by());
        jobSettingDB.setLast_update_date(new Date());

        return jobSettingRepository.save(jobSettingDB);
    }

    @Override
    public Boolean deleteJobSetting(Long id) {
        JobSetting jobSettingDB = getJobSetting(id);
        if(null == jobSettingDB){
            return false;
        }

        jobSettingRepository.deleteById(id);
        return true;
    }

    @Override
    public JobSetting findByCode(String code) {
        return jobSettingRepository.findByCode(code);
    }
}
