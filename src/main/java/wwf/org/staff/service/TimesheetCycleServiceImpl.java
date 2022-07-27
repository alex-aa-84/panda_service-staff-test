package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TimesheetCycle;
import wwf.org.staff.repository.TimesheetCycleRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimesheetCycleServiceImpl implements TimesheetCycleService {

    @Autowired
    private TimesheetCycleRepository repository;


    @Override
    public List<TimesheetCycle> listAllTimesheetCycle() {
        return repository.findAll();
    }

    @Override
    public TimesheetCycle getTimesheetCycle(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TimesheetCycle createTimesheetCycle(TimesheetCycle value) {
        value.setStatus("CREATED");
        value.setCreation_date(new Date());
        value.setLast_update_date(new Date());

        return repository.save(value);
    }

    @Override
    public TimesheetCycle updateTimesheetCycle(TimesheetCycle value) {
        TimesheetCycle bd = getTimesheetCycle(value.getId());
        if(null == bd){
            return null;
        }

        bd.setFiscalYear(value.getFiscalYear());
        bd.setMonthFiscalYear(value.getMonthFiscalYear());
        bd.setOnGoing(value.getOnGoing());

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
    public Boolean deleteTimesheetCycle(Long id) {
        TimesheetCycle bd = getTimesheetCycle(id);
        if(null == bd){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public TimesheetCycle findByFiscalYearAndMonthFiscalYear(Integer year, Integer month) {
        return repository.findByFiscalYearAndMonthFiscalYear(year, month);
    }

    @Override
    public TimesheetCycle findByOnGoing(Integer onGoing) {
        return repository.findByOnGoing(onGoing);
    }


}
