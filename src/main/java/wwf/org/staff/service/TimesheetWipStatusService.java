package wwf.org.staff.service;

import wwf.org.staff.entity.TimesheetWipStatus;

import java.util.List;

public interface TimesheetWipStatusService {
    public List<TimesheetWipStatus> listAllTimesheetWipStatus();

    public TimesheetWipStatus getTimesheetWipStatus(Long id);

    public TimesheetWipStatus createTimesheetWipStatus(TimesheetWipStatus value);
    public TimesheetWipStatus updateTimesheetWipStatus(TimesheetWipStatus value);
    public Boolean deleteTimesheetWipStatus(Long id);

    public TimesheetWipStatus findByTimesheetWipStatus(String val);
}
