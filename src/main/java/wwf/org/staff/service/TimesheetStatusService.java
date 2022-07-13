package wwf.org.staff.service;

import wwf.org.staff.entity.TimesheetStatus;

import java.util.List;

public interface TimesheetStatusService {
    public List<TimesheetStatus> listAllTimesheetStatus();

    public TimesheetStatus getTimesheetStatus(Long id);

    public TimesheetStatus createTimesheetStatus(TimesheetStatus value);
    public TimesheetStatus updateTimesheetStatus(TimesheetStatus value);
    public Boolean deleteTimesheetStatus(Long id);

    public TimesheetStatus findByName(String name);
}
