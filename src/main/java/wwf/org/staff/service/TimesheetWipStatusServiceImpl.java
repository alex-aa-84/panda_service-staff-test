package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TimesheetWipStatus;
import wwf.org.staff.repository.TimesheetWipStatusRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimesheetWipStatusServiceImpl implements TimesheetWipStatusService{

    @Autowired
    private TimesheetWipStatusRepository repository;


    @Override
    public List<TimesheetWipStatus> listAllTimesheetWipStatus() {
        return repository.findAll();
    }

    @Override
    public TimesheetWipStatus getTimesheetWipStatus(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TimesheetWipStatus createTimesheetWipStatus(TimesheetWipStatus value) {
        value.setStatus("CREATED");
        value.setCreation_date(new Date());
        value.setLast_update_date(new Date());

        return repository.save(value);
    }

    @Override
    public TimesheetWipStatus updateTimesheetWipStatus(TimesheetWipStatus value) {
        TimesheetWipStatus bd = getTimesheetWipStatus(value.getId());
        if(null == bd){
            return null;
        }

        bd.setTimesheetWipStatus(value.getTimesheetWipStatus());

        bd.setDescription(value.getDescription());

        bd.setAttribute1(value.getAttribute1());
        bd.setAttribute2(value.getAttribute2());
        bd.setAttribute3(value.getAttribute3());
        bd.setAttribute4(value.getAttribute4());
        bd.setAttribute5(value.getAttribute5());
        bd.setAttribute6(value.getAttribute6());
        bd.setAttribute7(value.getAttribute7());
        bd.setAttribute8(value.getAttribute8());
        bd.setAttribute9(value.getAttribute9());
        bd.setAttribute10(value.getAttribute10());

        bd.setStatus(value.getStatus());

        bd.setLast_update_by(value.getLast_update_by());
        bd.setLast_update_date(new Date());

        return repository.save(bd);
    }

    @Override
    public Boolean deleteTimesheetWipStatus(Long id) {
        TimesheetWipStatus bd = getTimesheetWipStatus(id);
        if(null == bd){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public TimesheetWipStatus findByTimesheetWipStatus(String val) {
        return repository.findByTimesheetWipStatus(val);
    }
}
