package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TimesheetSignature;
import wwf.org.staff.entity.TimesheetSignature;
import wwf.org.staff.repository.TimesheetSignatureRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimesheetSignatureServiceImpl implements TimesheetSignatureService {

    @Autowired
    private TimesheetSignatureRepository timesheetSignatureRepository;

    @Override
    public List<TimesheetSignature> listAllTimesheetSignature() {
        return timesheetSignatureRepository.findAll();
    }

    @Override
    public TimesheetSignature getTimesheetSignature(Long id) {
        return timesheetSignatureRepository.findById(id).orElse(null);
    }

    @Override
    public TimesheetSignature createTimesheetSignature(TimesheetSignature timesheetSignature) {
        timesheetSignature.setStatus("CREATED");
        timesheetSignature.setCreation_date(new Date());
        timesheetSignature.setLast_update_date(new Date());

        return timesheetSignatureRepository.save(timesheetSignature);
    }

    @Override
    public TimesheetSignature updateTimesheetSignature(TimesheetSignature timesheetSignature) {
        TimesheetSignature timesheetSignatureDB = getTimesheetSignature(timesheetSignature.getId());
        if(null == timesheetSignatureDB){
            return null;
        }

        timesheetSignatureDB.setTimesheetHeader(timesheetSignature.getTimesheetHeader());
        timesheetSignatureDB.setWorkflowSteps(timesheetSignature.getWorkflowSteps());
        timesheetSignatureDB.setSignature(timesheetSignature.getSignature());
        timesheetSignatureDB.setUserId(timesheetSignature.getUserId());

        timesheetSignatureDB.setAttribute1(timesheetSignature.getAttribute1());
        timesheetSignatureDB.setAttribute2(timesheetSignature.getAttribute2());
        timesheetSignatureDB.setAttribute3(timesheetSignature.getAttribute3());
        timesheetSignatureDB.setAttribute4(timesheetSignature.getAttribute4());
        timesheetSignatureDB.setAttribute5(timesheetSignature.getAttribute5());
        timesheetSignatureDB.setAttribute6(timesheetSignature.getAttribute6());
        timesheetSignatureDB.setAttribute7(timesheetSignature.getAttribute7());
        timesheetSignatureDB.setAttribute8(timesheetSignature.getAttribute8());
        timesheetSignatureDB.setAttribute9(timesheetSignature.getAttribute9());
        timesheetSignatureDB.setAttribute10(timesheetSignature.getAttribute10());

        timesheetSignatureDB.setStatus(timesheetSignature.getStatus());

        timesheetSignatureDB.setLast_update_by(timesheetSignature.getLast_update_by());
        timesheetSignatureDB.setLast_update_date(new Date());

        return timesheetSignatureRepository.save(timesheetSignatureDB);
    }

    @Override
    public Boolean deleteTimesheetSignature(Long id) {
        TimesheetSignature timesheetSignatureDB = getTimesheetSignature(id);
        if(null == timesheetSignatureDB){
            return false;
        }

        timesheetSignatureRepository.deleteById(id);
        return true;
    }

}
