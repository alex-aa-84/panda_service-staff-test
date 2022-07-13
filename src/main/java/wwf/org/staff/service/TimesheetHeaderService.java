package wwf.org.staff.service;

import wwf.org.staff.entity.TimesheetHeader;

import java.util.List;

public interface TimesheetHeaderService {
    public List<TimesheetHeader> listAllTimesheetHeader();

    public TimesheetHeader getTimesheetHeader(Long id);

    public TimesheetHeader createTimesheetHeader(TimesheetHeader timesheetHeader);
    public TimesheetHeader updateTimesheetHeader(TimesheetHeader timesheetHeader);
    public Boolean deleteTimesheetHeader(Long id);
}
