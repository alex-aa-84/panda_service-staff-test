package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TimesheetVersionSelect;
import wwf.org.staff.repository.TimesheetVersionSelectRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TimesheetVersionSelectServiceImpl implements TimesheetVersionSelectService {

    @Autowired
    private TimesheetVersionSelectRepository timesheetVersionSelectRepository;

    @Override
    public TimesheetVersionSelect getTimesheetVersionSelect(Long id) {
        return timesheetVersionSelectRepository.findById(id).orElse(null);
    }

    @Override
    public TimesheetVersionSelect updateTimesheetVersionSelect(TimesheetVersionSelect timesheetVersionSelect) {
        TimesheetVersionSelect timesheetVersionSelectDB = getTimesheetVersionSelect(timesheetVersionSelect.getId());

        if(null == timesheetVersionSelectDB){
            return null;
        }

        timesheetVersionSelectDB.setTimesheetVersionId(timesheetVersionSelect.getTimesheetVersionId());

        timesheetVersionSelectDB.setAttribute1(timesheetVersionSelect.getAttribute1());
        timesheetVersionSelectDB.setAttribute2(timesheetVersionSelect.getAttribute2());
        timesheetVersionSelectDB.setAttribute3(timesheetVersionSelect.getAttribute3());
        timesheetVersionSelectDB.setAttribute4(timesheetVersionSelect.getAttribute4());
        timesheetVersionSelectDB.setAttribute5(timesheetVersionSelect.getAttribute5());
        timesheetVersionSelectDB.setAttribute6(timesheetVersionSelect.getAttribute6());
        timesheetVersionSelectDB.setAttribute7(timesheetVersionSelect.getAttribute7());
        timesheetVersionSelectDB.setAttribute8(timesheetVersionSelect.getAttribute8());
        timesheetVersionSelectDB.setAttribute9(timesheetVersionSelect.getAttribute9());
        timesheetVersionSelectDB.setAttribute10(timesheetVersionSelect.getAttribute10());

        timesheetVersionSelectDB.setStatus(timesheetVersionSelect.getStatus());

        timesheetVersionSelectDB.setLast_update_by(timesheetVersionSelect.getLast_update_by());
        timesheetVersionSelectDB.setLast_update_date(new Date());

        return timesheetVersionSelectRepository.save(timesheetVersionSelectDB);
    }

}
