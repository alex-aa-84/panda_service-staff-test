package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.RequestPermitDays;
import wwf.org.staff.repository.RequestPermitDaysRepository;
import wwf.org.staff.serviceApi.MD5Util;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestPermitDaysServiceImpl implements RequestPermitDaysService {

    @Autowired
    private RequestPermitDaysRepository requestPermitDays;

    @Override
    public List<RequestPermitDays> listAllRequestPermitDays() {
        return requestPermitDays.findAll();
    }

    @Override
    public RequestPermitDays getRequestPermitDays(Long id) {
        return requestPermitDays.findById(id).orElse(null);
    }

    @Override
    public RequestPermitDays createRequestPermitDays(RequestPermitDays requestPermitDay) {
        requestPermitDay.setStatus("CREATED");
        requestPermitDay.setCreation_date(new Date());
        requestPermitDay.setLast_update_date(new Date());

        /*String md5 = MD5Util.string2MD5("primero");
        requestPermitDay.setCtrlMd5(md5);*/

        return requestPermitDays.save(requestPermitDay);
    }

    @Override
    public RequestPermitDays updateRequestPermitDays(RequestPermitDays requestPermitDay) {
        RequestPermitDays requestPermitDayDB = getRequestPermitDays(requestPermitDay.getId());
        if(null == requestPermitDayDB){
            return null;
        }

        requestPermitDayDB.setCalendarId(requestPermitDay.getCalendarId());

        requestPermitDayDB.setAttribute1(requestPermitDay.getAttribute1());
        requestPermitDayDB.setAttribute2(requestPermitDay.getAttribute2());
        requestPermitDayDB.setAttribute3(requestPermitDay.getAttribute3());
        requestPermitDayDB.setAttribute4(requestPermitDay.getAttribute4());
        requestPermitDayDB.setAttribute5(requestPermitDay.getAttribute5());
        requestPermitDayDB.setAttribute6(requestPermitDay.getAttribute6());
        requestPermitDayDB.setAttribute7(requestPermitDay.getAttribute7());
        requestPermitDayDB.setAttribute8(requestPermitDay.getAttribute8());
        requestPermitDayDB.setAttribute9(requestPermitDay.getAttribute9());
        requestPermitDayDB.setAttribute10(requestPermitDay.getAttribute10());

        requestPermitDayDB.setStatus(requestPermitDay.getStatus());

        requestPermitDayDB.setLast_update_by(requestPermitDay.getLast_update_by());
        requestPermitDayDB.setLast_update_date(new Date());

        return requestPermitDays.save(requestPermitDayDB);
    }

    @Override
    public Boolean deleteRequestPermitDays(Long id) {
        RequestPermitDays requestPermitDayDB = getRequestPermitDays(id);
        if(null == requestPermitDayDB){
            return false;
        }

        requestPermitDays.deleteById(id);
        return true;
    }
}
