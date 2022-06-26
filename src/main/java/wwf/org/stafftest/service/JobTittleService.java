package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.JobTittle;

import java.util.List;

public interface JobTittleService {
    public List<JobTittle> listAllJobTittle();
    public JobTittle getJobTittle(Long id);

    public JobTittle createJobTittle(JobTittle jobTittle);
    public JobTittle updateJobTittle(JobTittle jobTittle);
    public Boolean deleteJobTittle(Long id);
    public JobTittle findByJobTitle(String jobTitle);
}
