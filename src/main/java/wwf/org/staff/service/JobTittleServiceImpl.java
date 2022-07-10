package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.JobTittle;
import wwf.org.staff.repository.JobTitleRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobTittleServiceImpl implements JobTittleService{

    @Autowired
    private JobTitleRepository jobTitleRepository;

    @Override
    public List<JobTittle> listAllJobTittle() {
        return jobTitleRepository.findAll();
    }

    @Override
    public JobTittle getJobTittle(Long id) {
        return jobTitleRepository.findById(id).orElse(null);
    }

    @Override
    public JobTittle createJobTittle(JobTittle jobTittle) {
        jobTittle.setStatus("CREATED");
        jobTittle.setCreation_date(new Date());
        jobTittle.setLast_update_date(new Date());

        return jobTitleRepository.save(jobTittle);
    }

    @Override
    public JobTittle updateJobTittle(JobTittle jobTittle) {
        JobTittle jobTittleDB = getJobTittle(jobTittle.getId());
        if(null == jobTittleDB){
            return null;
        }

        jobTittleDB.setJobTitle(jobTittle.getJobTitle());
        jobTittleDB.setDescription(jobTittle.getDescription());

        jobTittleDB.setAttribute1(jobTittle.getAttribute1());
        jobTittleDB.setAttribute2(jobTittle.getAttribute2());
        jobTittleDB.setAttribute3(jobTittle.getAttribute3());
        jobTittleDB.setAttribute4(jobTittle.getAttribute4());
        jobTittleDB.setAttribute5(jobTittle.getAttribute5());
        jobTittleDB.setAttribute6(jobTittle.getAttribute6());
        jobTittleDB.setAttribute7(jobTittle.getAttribute7());
        jobTittleDB.setAttribute8(jobTittle.getAttribute8());
        jobTittleDB.setAttribute9(jobTittle.getAttribute9());
        jobTittleDB.setAttribute10(jobTittle.getAttribute10());

        jobTittleDB.setStatus(jobTittle.getStatus());

        jobTittleDB.setLast_update_by(jobTittle.getLast_update_by());
        jobTittleDB.setLast_update_date(new Date());

        return jobTitleRepository.save(jobTittleDB);
    }

    @Override
    public Boolean deleteJobTittle(Long id) {
        JobTittle jobTittleDB = getJobTittle(id);
        if(null == jobTittleDB){
            return false;
        }

        jobTitleRepository.deleteById(id);
        return true;
    }

    @Override
    public JobTittle findByJobTitle(String jobTitle) {
        return jobTitleRepository.findByJobTitle(jobTitle);
    }
}
