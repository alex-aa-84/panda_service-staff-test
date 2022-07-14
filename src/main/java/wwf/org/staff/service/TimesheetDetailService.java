package wwf.org.staff.service;

import wwf.org.staff.entity.TimesheetDetails;

import java.util.List;

public interface TimesheetDetailService {

    public List<TimesheetDetails> listAllTimesheetDetails();

    public TimesheetDetails getTimesheetDetails(Long id);

    public TimesheetDetails createTimesheetDetails(TimesheetDetails value);
    public TimesheetDetails updateTimesheetDetails(TimesheetDetails value);
    public Boolean deleteTimesheetDetails(Long id);
}
