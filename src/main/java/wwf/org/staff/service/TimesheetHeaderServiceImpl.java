package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TimesheetHeader;
import wwf.org.staff.repository.TimesheetHeaderRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimesheetHeaderServiceImpl implements TimesheetHeaderService {
    @Autowired
    private TimesheetHeaderRepository timesheetHeader;

    @Override
    public List<TimesheetHeader> listAllTimesheetHeader() {
        return timesheetHeader.findAll();
    }

    @Override
    public TimesheetHeader getTimesheetHeader(Long id) {
        return timesheetHeader.findById(id).orElse(null);
    }

    @Override
    public TimesheetHeader createTimesheetHeader(TimesheetHeader tmesheetHeader) {
        tmesheetHeader.setStatus("CREATED");
        tmesheetHeader.setCreation_date(new Date());
        tmesheetHeader.setLast_update_date(new Date());

        return timesheetHeader.save(tmesheetHeader);
    }

    @Override
    public TimesheetHeader updateTimesheetHeader(TimesheetHeader tmesheetHeader) {
        TimesheetHeader tmesheetHeaderDB = getTimesheetHeader(tmesheetHeader.getId());
        if(null == tmesheetHeaderDB){
            return null;
        }

        tmesheetHeaderDB.setUserId(tmesheetHeader.getUserId());
        tmesheetHeaderDB.setTimesheetCycle(tmesheetHeader.getTimesheetCycle());
        tmesheetHeaderDB.setWorkflowSteps(tmesheetHeader.getWorkflowSteps());
        tmesheetHeaderDB.setLastUpdateWorkflowSteps(tmesheetHeader.getLastUpdateWorkflowSteps());
        tmesheetHeaderDB.setWorkflowWipStatus(tmesheetHeader.getWorkflowWipStatus());
        tmesheetHeaderDB.setTimesheetStatusId(tmesheetHeader.getTimesheetStatusId());
        tmesheetHeaderDB.setObservation(tmesheetHeader.getObservation());

        tmesheetHeaderDB.setAttribute1(tmesheetHeader.getAttribute1());
        tmesheetHeaderDB.setAttribute2(tmesheetHeader.getAttribute2());
        tmesheetHeaderDB.setAttribute3(tmesheetHeader.getAttribute3());
        tmesheetHeaderDB.setAttribute4(tmesheetHeader.getAttribute4());
        tmesheetHeaderDB.setAttribute5(tmesheetHeader.getAttribute5());
        tmesheetHeaderDB.setAttribute6(tmesheetHeader.getAttribute6());
        tmesheetHeaderDB.setAttribute7(tmesheetHeader.getAttribute7());
        tmesheetHeaderDB.setAttribute8(tmesheetHeader.getAttribute8());
        tmesheetHeaderDB.setAttribute9(tmesheetHeader.getAttribute9());
        tmesheetHeaderDB.setAttribute10(tmesheetHeader.getAttribute10());

        tmesheetHeaderDB.setStatus(tmesheetHeader.getStatus());

        tmesheetHeaderDB.setLast_update_by(tmesheetHeader.getLast_update_by());
        tmesheetHeaderDB.setLast_update_date(new Date());

        return timesheetHeader.save(tmesheetHeaderDB);
    }

    @Override
    public Boolean deleteTimesheetHeader(Long id) {
        TimesheetHeader tmesheetHeaderDB = getTimesheetHeader(id);
        if(null == tmesheetHeaderDB){
            return false;
        }

        timesheetHeader.deleteById(id);
        return true;
    }

}
