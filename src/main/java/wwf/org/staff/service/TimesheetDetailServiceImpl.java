package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.TimesheetDetails;
import wwf.org.staff.repository.TimesheetDetailRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimesheetDetailServiceImpl implements TimesheetDetailService{

    @Autowired
    private TimesheetDetailRepository repository;

    @Override
    public List<TimesheetDetails> listAllTimesheetDetails() {
        return repository.findAll();
    }

    @Override
    public TimesheetDetails getTimesheetDetails(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TimesheetDetails createTimesheetDetails(TimesheetDetails data) {
        data.setStatus("CREATED");
        data.setCreation_date(new Date());
        data.setLast_update_date(new Date());

        return repository.save(data);
    }

    @Override
    public TimesheetDetails updateTimesheetDetails(TimesheetDetails data) {
        TimesheetDetails dataDB = getTimesheetDetails(data.getId());
        if(null == dataDB){
            return null;
        }

        dataDB.setTimesheetHeader(data.getTimesheetHeader());
        dataDB.setProjectsSheets(data.getProjectsSheets());
        dataDB.setRequestType(data.getRequestType());

        dataDB.setAttribute1(data.getAttribute1());
        dataDB.setAttribute2(data.getAttribute2());
        dataDB.setAttribute3(data.getAttribute3());
        dataDB.setAttribute4(data.getAttribute4());
        dataDB.setAttribute5(data.getAttribute5());
        dataDB.setAttribute6(data.getAttribute6());
        dataDB.setAttribute7(data.getAttribute7());
        dataDB.setAttribute8(data.getAttribute8());
        dataDB.setAttribute9(data.getAttribute9());
        dataDB.setAttribute10(data.getAttribute10());

        dataDB.setStatus(data.getStatus());

        dataDB.setLast_update_by(data.getLast_update_by());
        dataDB.setLast_update_date(new Date());

        return repository.save(dataDB);
    }

    @Override
    public Boolean deleteTimesheetDetails(Long id) {
        TimesheetDetails dataDB = getTimesheetDetails(id);
        if(null == dataDB){
            return false;
        }

        repository.deleteById(id);
        return true;
    }


}
