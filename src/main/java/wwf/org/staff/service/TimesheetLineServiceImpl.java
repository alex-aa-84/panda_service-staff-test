package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TimesheetLines;
import wwf.org.staff.entity.TimesheetLines;
import wwf.org.staff.repository.TimesheetLineRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimesheetLineServiceImpl implements TimesheetLineService {

    @Autowired
    private TimesheetLineRepository timesheetLineRepository;

    @Override
    public List<TimesheetLines> listAllTimesheetLines() {
        return timesheetLineRepository.findAll();
    }

    @Override
    public TimesheetLines getTimesheetLines(Long id) {
        return timesheetLineRepository.findById(id).orElse(null);
    }

    @Override
    public TimesheetLines createTimesheetLines(TimesheetLines timesheetLine) {
        timesheetLine.setStatus("CREATED");
        timesheetLine.setCreation_date(new Date());
        timesheetLine.setLast_update_date(new Date());

        return timesheetLineRepository.save(timesheetLine);
    }

    @Override
    public TimesheetLines updateTimesheetLines(TimesheetLines timesheetLine) {
        TimesheetLines timesheetLineDB = getTimesheetLines(timesheetLine.getId());
        if(null == timesheetLineDB){
            return null;
        }

        timesheetLineDB.setTimesheetHeader(timesheetLine.getTimesheetHeader());
        timesheetLineDB.setTimesheetType(timesheetLine.getTimesheetType());
        timesheetLineDB.setRequestPermitType(timesheetLine.getRequestPermitType());
        timesheetLineDB.setProjectsSheets(timesheetLine.getProjectsSheets());
        timesheetLineDB.setRequestPermitHeader(timesheetLine.getRequestPermitHeader());
        timesheetLineDB.setCalendarId(timesheetLine.getCalendarId());
        timesheetLineDB.setWorkedHours(timesheetLine.getWorkedHours());
        timesheetLineDB.setDisabledField(timesheetLine.getDisabledField());

        timesheetLineDB.setAttribute1(timesheetLine.getAttribute1());
        timesheetLineDB.setAttribute2(timesheetLine.getAttribute2());
        timesheetLineDB.setAttribute3(timesheetLine.getAttribute3());
        timesheetLineDB.setAttribute4(timesheetLine.getAttribute4());
        timesheetLineDB.setAttribute5(timesheetLine.getAttribute5());
        timesheetLineDB.setAttribute6(timesheetLine.getAttribute6());
        timesheetLineDB.setAttribute7(timesheetLine.getAttribute7());
        timesheetLineDB.setAttribute8(timesheetLine.getAttribute8());
        timesheetLineDB.setAttribute9(timesheetLine.getAttribute9());
        timesheetLineDB.setAttribute10(timesheetLine.getAttribute10());

        timesheetLineDB.setStatus(timesheetLine.getStatus());

        timesheetLineDB.setLast_update_by(timesheetLine.getLast_update_by());
        timesheetLineDB.setLast_update_date(new Date());

        return timesheetLineRepository.save(timesheetLineDB);
    }

    @Override
    public Boolean deleteTimesheetLines(Long id) {
        TimesheetLines timesheetLineDB = getTimesheetLines(id);
        if(null == timesheetLineDB){
            return false;
        }

        timesheetLineRepository.deleteById(id);
        return true;
    }

}
