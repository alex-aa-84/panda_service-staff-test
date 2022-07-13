package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.RequestPermitDays;
import wwf.org.staff.repository.RequestPermitDaysRepository;

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
    public RequestPermitDays createRequestPermitDays(RequestPermitDays relationship) {
        relationship.setStatus("CREATED");
        relationship.setCreation_date(new Date());
        relationship.setLast_update_date(new Date());

        return requestPermitDays.save(relationship);
    }

    @Override
    public RequestPermitDays updateRequestPermitDays(RequestPermitDays relationship) {
        RequestPermitDays relationshipDB = getRequestPermitDays(relationship.getId());
        if(null == relationshipDB){
            return null;
        }

        relationshipDB.setRequestPermitPeriods(relationship.getRequestPermitPeriods());
        relationshipDB.setCalendarId(relationship.getCalendarId());

        relationshipDB.setAttribute1(relationship.getAttribute1());
        relationshipDB.setAttribute2(relationship.getAttribute2());
        relationshipDB.setAttribute3(relationship.getAttribute3());
        relationshipDB.setAttribute4(relationship.getAttribute4());
        relationshipDB.setAttribute5(relationship.getAttribute5());
        relationshipDB.setAttribute6(relationship.getAttribute6());
        relationshipDB.setAttribute7(relationship.getAttribute7());
        relationshipDB.setAttribute8(relationship.getAttribute8());
        relationshipDB.setAttribute9(relationship.getAttribute9());
        relationshipDB.setAttribute10(relationship.getAttribute10());

        relationshipDB.setStatus(relationship.getStatus());

        relationshipDB.setLast_update_by(relationship.getLast_update_by());
        relationshipDB.setLast_update_date(new Date());

        return requestPermitDays.save(relationshipDB);
    }

    @Override
    public Boolean deleteRequestPermitDays(Long id) {
        RequestPermitDays relationshipDB = getRequestPermitDays(id);
        if(null == relationshipDB){
            return false;
        }

        requestPermitDays.deleteById(id);
        return true;
    }

    @Override
    public RequestPermitDays findByRequestPermitPeriodsIdAndCalendarId(Long requestPermitPeriods, Long calendarId) {
        return requestPermitDays.findByRequestPermitPeriodsIdAndCalendarId(requestPermitPeriods, calendarId);
    }
}
