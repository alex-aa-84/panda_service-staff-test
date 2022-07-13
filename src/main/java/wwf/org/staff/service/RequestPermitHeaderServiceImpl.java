package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.RequestPermitHeader;
import wwf.org.staff.repository.RequestPermitHeaderRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestPermitHeaderServiceImpl implements RequestPermitHeaderService {

    @Autowired
    private RequestPermitHeaderRepository requestPermitHeaderRepository;

    @Override
    public List<RequestPermitHeader> listAllRequestPermitHeader() {
        return requestPermitHeaderRepository.findAll();
    }

    @Override
    public RequestPermitHeader getRequestPermitHeader(Long id) {
        return requestPermitHeaderRepository.findById(id).orElse(null);
    }

    @Override
    public RequestPermitHeader createRequestPermitHeader(RequestPermitHeader requestPermitHeader) {
        requestPermitHeader.setStatus("CREATED");
        requestPermitHeader.setCreation_date(new Date());
        requestPermitHeader.setLast_update_date(new Date());

        return requestPermitHeaderRepository.save(requestPermitHeader);
    }

    @Override
    public RequestPermitHeader updateRequestPermitHeader(RequestPermitHeader requestPermitHeader) {
        RequestPermitHeader requestPermitHeaderDB = getRequestPermitHeader(requestPermitHeader.getId());
        if(null == requestPermitHeaderDB){
            return null;
        }

        requestPermitHeaderDB.setUserId(requestPermitHeader.getUserId());
        requestPermitHeaderDB.setRequestPermitType(requestPermitHeader.getRequestPermitType());
        requestPermitHeaderDB.setDateRequest(requestPermitHeader.getDateRequest());
        requestPermitHeaderDB.setDays(requestPermitHeader.getDays());
        requestPermitHeaderDB.setWorkflowSteps(requestPermitHeader.getWorkflowSteps());
        requestPermitHeaderDB.setLastUpdateWorkflowSteps(requestPermitHeader.getLastUpdateWorkflowSteps());
        requestPermitHeaderDB.setWorkflowWipStatus(requestPermitHeader.getWorkflowWipStatus());
        requestPermitHeaderDB.setObservation(requestPermitHeader.getObservation());

        requestPermitHeaderDB.setAttribute1(requestPermitHeader.getAttribute1());
        requestPermitHeaderDB.setAttribute2(requestPermitHeader.getAttribute2());
        requestPermitHeaderDB.setAttribute3(requestPermitHeader.getAttribute3());
        requestPermitHeaderDB.setAttribute4(requestPermitHeader.getAttribute4());
        requestPermitHeaderDB.setAttribute5(requestPermitHeader.getAttribute5());
        requestPermitHeaderDB.setAttribute6(requestPermitHeader.getAttribute6());
        requestPermitHeaderDB.setAttribute7(requestPermitHeader.getAttribute7());
        requestPermitHeaderDB.setAttribute8(requestPermitHeader.getAttribute8());
        requestPermitHeaderDB.setAttribute9(requestPermitHeader.getAttribute9());
        requestPermitHeaderDB.setAttribute10(requestPermitHeader.getAttribute10());

        requestPermitHeaderDB.setStatus(requestPermitHeader.getStatus());

        requestPermitHeaderDB.setLast_update_by(requestPermitHeader.getLast_update_by());
        requestPermitHeaderDB.setLast_update_date(new Date());

        return requestPermitHeaderRepository.save(requestPermitHeaderDB);
    }

    @Override
    public Boolean deleteRequestPermitHeader(Long id) {
        RequestPermitHeader requestPermitHeaderDB = getRequestPermitHeader(id);
        if(null == requestPermitHeaderDB){
            return false;
        }

        requestPermitHeaderRepository.deleteById(id);
        return true;
    }

}
