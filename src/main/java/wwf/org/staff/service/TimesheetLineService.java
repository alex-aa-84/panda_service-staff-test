package wwf.org.staff.service;

import wwf.org.staff.entity.TimesheetLines;

import java.util.List;

public interface TimesheetLineService {
    public List<TimesheetLines> listAllTimesheetLines();

    public TimesheetLines getTimesheetLines(Long id);

    public TimesheetLines createTimesheetLines(TimesheetLines value);
    public TimesheetLines updateTimesheetLines(TimesheetLines value);
    public Boolean deleteTimesheetLines(Long id);
}
