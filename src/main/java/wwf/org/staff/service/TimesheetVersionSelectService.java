package wwf.org.staff.service;

import wwf.org.staff.entity.TimesheetVersionSelect;

import java.util.List;

public interface TimesheetVersionSelectService {

    public TimesheetVersionSelect getTimesheetVersionSelect(Long id);

    public TimesheetVersionSelect updateTimesheetVersionSelect(TimesheetVersionSelect timesheetVersionSelect);

}
