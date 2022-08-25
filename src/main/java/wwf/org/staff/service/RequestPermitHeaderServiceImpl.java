package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.RequestPermitHeader;
import wwf.org.staff.repository.RequestPermitHeaderRepository;
import wwf.org.staff.serviceApi.MD5Util;

import java.text.SimpleDateFormat;
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
    public RequestPermitHeader createRequestPermitHeader(RequestPermitHeader r) {
        r.setStatus("CREATED");
        r.setCreation_date(new Date());
        r.setLast_update_date(new Date());

        r.setCtrlMd5(generateMd5(r.toString()));

        r.getRequestPermitPeriods().stream().forEach((p)->{
            p.setStatus("CREATED");
            p.setCreation_date(new Date());
            p.setLast_update_date(new Date());
            p.setCtrlMd5(generateMd5(p.toString()));
            p.getRequestPermitDays().stream().forEach((d)->{
                d.setStatus("CREATED");
                d.setCreation_date(new Date());
                d.setLast_update_date(new Date());
                d.setCreate_by(p.getCreate_by());
                d.setLast_update_by(p.getLast_update_by());
                d.setCtrlMd5(generateMd5(d.toString()));
            });
        });

        r.getRequestPermitSignatures().stream().forEach((p)->{
            p.setStatus("CREATED");
            p.setCreation_date(new Date());
            p.setLast_update_date(new Date());
            p.setCreate_by(r.getCreate_by());
            p.setLast_update_by(r.getLast_update_by());
            p.setCtrlMd5(generateMd5(p.toString()));
        });



        RequestPermitHeader header = requestPermitHeaderRepository.save(r);
       
        return generateNumberRequest(header);
    }

    @Override
    public RequestPermitHeader generateNumberRequest(RequestPermitHeader header) {

        Date date = new Date();

        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String currentYear = getYearFormat.format(date);
        
        header.setNumberSolict("RP-"+header.getId()+"-"+currentYear);
        
        return requestPermitHeaderRepository.save(header);
    }

    @Override
    public String generateMd5(String text) {

        String md5 = MD5Util.string2MD5(text);
        return md5;
    }

    @Override
    public RequestPermitHeader updateRequestPermitHeader(RequestPermitHeader requestPermitHeader) {
        RequestPermitHeader requestPermitHeaderDB = getRequestPermitHeader(requestPermitHeader.getId());
        if(null == requestPermitHeaderDB){
            return null;
        }

        requestPermitHeaderDB.setUserId(requestPermitHeader.getUserId());
        requestPermitHeaderDB.setRequestType(requestPermitHeader.getRequestType());
        requestPermitHeaderDB.setDateRequest(requestPermitHeader.getDateRequest());
        requestPermitHeaderDB.setWorkflowSteps(requestPermitHeader.getWorkflowSteps());
        requestPermitHeaderDB.setLastUpdateWorkflowSteps(requestPermitHeader.getLastUpdateWorkflowSteps());
        requestPermitHeaderDB.setWorkflowWipStatus(requestPermitHeader.getWorkflowWipStatus());
        requestPermitHeaderDB.setFlagHours(requestPermitHeader.getFlagHours());
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

    @Override
    public RequestPermitHeader findByNumberSolict(String numberSolict) {
        // TODO Auto-generated method stub
        return requestPermitHeaderRepository.findByNumberSolict(numberSolict);
    }

    @Override
    public List<RequestPermitHeader> findByUserId(Long userId) {
        // TODO Auto-generated method stub
        return requestPermitHeaderRepository.findByUserId(userId);
    }

    @Override
    public List<RequestPermitHeader> findStatusRequest(Number state, Long userId) {
        // TODO Auto-generated method stub
        return requestPermitHeaderRepository.findStatusRequest(state, userId);
    }

    @Override
    public List<RequestPermitHeader> findStatusRequestTo(Number state, Date dateTo, Long userId) {
        // TODO Auto-generated method stub
        return requestPermitHeaderRepository.findStatusRequestTo(state, dateTo, userId);
    }

    @Override
    public List<RequestPermitHeader> findStatusRequestFrom(Number state, Date dateFrom, Long userId) {
        // TODO Auto-generated method stub
        return requestPermitHeaderRepository.findStatusRequestFrom(state, dateFrom, userId);
    }

    @Override
    public List<RequestPermitHeader> findStatusRequestFromTo(Number state, Date dateFrom, Date dateTo, Long userId) {
        // TODO Auto-generated method stub
        return requestPermitHeaderRepository.findStatusRequestFromTo(state, dateFrom, dateTo, userId);
    }

    @Override
    public List<RequestPermitHeader> findStatusRequestDate(Date dateFrom, Date dateTo, Long userId) {
        // TODO Auto-generated method stub
        return requestPermitHeaderRepository.findStatusRequestDate(dateFrom, dateTo, userId);
    }

    @Override
    public List<RequestPermitHeader> findStatusRequestPendientes(Long userId) {
        // TODO Auto-generated method stub
        return requestPermitHeaderRepository.findStatusRequestPendientes(userId);
    }

}
