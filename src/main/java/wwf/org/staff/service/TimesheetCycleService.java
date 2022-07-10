package wwf.org.staff.service;

import wwf.org.staff.entity.TimesheetCycle;

import java.util.List;

public interface TimesheetCycleService {
    public List<TimesheetCycle> listAllTimesheetCycle();

    public TimesheetCycle getTimesheetCycle(Long id);

    public TimesheetCycle createTimesheetCycle(TimesheetCycle value);
    public TimesheetCycle updateTimesheetCycle(TimesheetCycle value);
    public Boolean deleteTimesheetCycle(Long id);

    public TimesheetCycle findByFiscalYearAndMonthFiscalYear(Integer year, Integer month);
}
