package wwf.org.staff.service;

import wwf.org.staff.entity.TimesheetSignature;

import java.util.List;

public interface TimesheetSignatureService {
    public List<TimesheetSignature> listAllTimesheetSignature();

    public TimesheetSignature getTimesheetSignature(Long id);

    public TimesheetSignature createTimesheetSignature(TimesheetSignature value);
    public TimesheetSignature updateTimesheetSignature(TimesheetSignature value);
    public Boolean deleteTimesheetSignature(Long id);
}
