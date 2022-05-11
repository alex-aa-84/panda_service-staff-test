package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.JobTittle;
import wwf.org.stafftest.repository.JobTitleRepository;

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
    public JobTittle createJobTittle(JobTittle jobTittle, Long userId) {
        jobTittle.setStatus("CREATED");
        jobTittle.setCreate_by(userId);
        jobTittle.setCreation_date(new Date());
        jobTittle.setLast_update_by(userId);
        jobTittle.setLast_update_date(new Date());

        return jobTitleRepository.save(jobTittle);
    }

    @Override
    public JobTittle updateJobTittle(JobTittle jobTittle, Long userId) {
        JobTittle jobTittleDB = getJobTittle(jobTittle.getId());
        if(null == jobTittleDB){
            return null;
        }

        jobTittle.setLast_update_by(userId);
        jobTittle.setLast_update_date(new Date());

        return jobTitleRepository.save(jobTittle);
    }

    @Override
    public JobTittle deleteJobTittle(Long id, Long userId) {
        JobTittle jobTittleDB = getJobTittle(id);
        if(null == jobTittleDB){
            return null;
        }

        jobTittleDB.setStatus("DELETED");
        jobTittleDB.setLast_update_by(userId);
        jobTittleDB.setLast_update_date(new Date());

        return jobTitleRepository.save(jobTittleDB);
    }
}
