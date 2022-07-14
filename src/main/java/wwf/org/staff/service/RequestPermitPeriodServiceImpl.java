package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.RequestPermitPeriods;
import wwf.org.staff.repository.RequestPermitPeriodRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestPermitPeriodServiceImpl implements RequestPermitPeriodService {
    @Autowired
    private RequestPermitPeriodRepository requestPermitPeriod;

    @Override
    public List<RequestPermitPeriods> listAllRequestPermitPeriods() {
        return requestPermitPeriod.findAll();
    }

    @Override
    public RequestPermitPeriods getRequestPermitPeriods(Long id) {
        return requestPermitPeriod.findById(id).orElse(null);
    }

    @Override
    public RequestPermitPeriods createRequestPermitPeriods(RequestPermitPeriods requestPermitPeriods) {
        requestPermitPeriods.setStatus("CREATED");
        requestPermitPeriods.setCreation_date(new Date());
        requestPermitPeriods.setLast_update_date(new Date());

        return requestPermitPeriod.save(requestPermitPeriods);
    }

    @Override
    public RequestPermitPeriods updateRequestPermitPeriods(RequestPermitPeriods requestPermitPeriods) {
        RequestPermitPeriods requestPermitPeriodsDB = getRequestPermitPeriods(requestPermitPeriods.getId());
        if(null == requestPermitPeriodsDB){
            return null;
        }

        requestPermitPeriodsDB.setRequestPermitHeader(requestPermitPeriods.getRequestPermitHeader());
        requestPermitPeriodsDB.setDateFrom(requestPermitPeriods.getDateFrom());
        requestPermitPeriodsDB.setDateTo(requestPermitPeriods.getDateTo());
        requestPermitPeriodsDB.setDays(requestPermitPeriods.getDays());

        requestPermitPeriodsDB.setAttribute1(requestPermitPeriods.getAttribute1());
        requestPermitPeriodsDB.setAttribute2(requestPermitPeriods.getAttribute2());
        requestPermitPeriodsDB.setAttribute3(requestPermitPeriods.getAttribute3());
        requestPermitPeriodsDB.setAttribute4(requestPermitPeriods.getAttribute4());
        requestPermitPeriodsDB.setAttribute5(requestPermitPeriods.getAttribute5());
        requestPermitPeriodsDB.setAttribute6(requestPermitPeriods.getAttribute6());
        requestPermitPeriodsDB.setAttribute7(requestPermitPeriods.getAttribute7());
        requestPermitPeriodsDB.setAttribute8(requestPermitPeriods.getAttribute8());
        requestPermitPeriodsDB.setAttribute9(requestPermitPeriods.getAttribute9());
        requestPermitPeriodsDB.setAttribute10(requestPermitPeriods.getAttribute10());

        requestPermitPeriodsDB.setStatus(requestPermitPeriods.getStatus());

        requestPermitPeriodsDB.setLast_update_by(requestPermitPeriods.getLast_update_by());
        requestPermitPeriodsDB.setLast_update_date(new Date());

        return requestPermitPeriod.save(requestPermitPeriodsDB);
    }

    @Override
    public Boolean deleteRequestPermitPeriods(Long id) {
        RequestPermitPeriods requestPermitPeriodsDB = getRequestPermitPeriods(id);
        if(null == requestPermitPeriodsDB){
            return false;
        }

        requestPermitPeriod.deleteById(id);
        return true;
    }
}
