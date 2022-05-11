package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.JobTittle;

import java.util.List;

public interface JobTittleService {
    public List<JobTittle> listAllJobTittle();
    public JobTittle getJobTittle(Long id);

    public JobTittle createJobTittle(JobTittle jobTittle, Long userId);
    public JobTittle updateJobTittle(JobTittle jobTittle, Long userId);
    public JobTittle deleteJobTittle(Long id, Long userId);
}
