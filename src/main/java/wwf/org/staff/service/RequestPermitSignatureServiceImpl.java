package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.RequestPermitSignature;
import wwf.org.staff.repository.RequestPermitSignatureRepository;
import wwf.org.staff.serviceApi.MD5Util;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestPermitSignatureServiceImpl implements RequestPermitSignatureService {

    @Autowired
    private RequestPermitSignatureRepository requestPermitSignature;

    @Override
    public List<RequestPermitSignature> listAllRequestPermitSignature() {
        return requestPermitSignature.findAll();
    }

    @Override
    public RequestPermitSignature getRequestPermitSignature(Long id) {
        return requestPermitSignature.findById(id).orElse(null);
    }

    @Override
    public RequestPermitSignature createRequestPermitSignature(RequestPermitSignature requestPermitS) {
        requestPermitS.setStatus("CREATED");
        requestPermitS.setCreation_date(new Date());
        requestPermitS.setLast_update_date(new Date());

        /*String md5 = MD5Util.string2MD5("cuarto");
        requestPermitS.setCtrlMd5(md5);*/

        return requestPermitSignature.save(requestPermitS);
    }

    @Override
    public RequestPermitSignature updateRequestPermitSignature(RequestPermitSignature requestPermitS) {
        RequestPermitSignature requestPermitSDB = getRequestPermitSignature(requestPermitS.getId());
        if(null == requestPermitSDB){
            return null;
        }

        requestPermitSDB.setWorkflowSteps(requestPermitS.getWorkflowSteps());
        requestPermitSDB.setSignature(requestPermitS.getSignature());
        requestPermitSDB.setUserId(requestPermitS.getUserId());

        requestPermitSDB.setAttribute1(requestPermitS.getAttribute1());
        requestPermitSDB.setAttribute2(requestPermitS.getAttribute2());
        requestPermitSDB.setAttribute3(requestPermitS.getAttribute3());
        requestPermitSDB.setAttribute4(requestPermitS.getAttribute4());
        requestPermitSDB.setAttribute5(requestPermitS.getAttribute5());
        requestPermitSDB.setAttribute6(requestPermitS.getAttribute6());
        requestPermitSDB.setAttribute7(requestPermitS.getAttribute7());
        requestPermitSDB.setAttribute8(requestPermitS.getAttribute8());
        requestPermitSDB.setAttribute9(requestPermitS.getAttribute9());
        requestPermitSDB.setAttribute10(requestPermitS.getAttribute10());

        requestPermitSDB.setStatus(requestPermitS.getStatus());

        requestPermitSDB.setLast_update_by(requestPermitS.getLast_update_by());
        requestPermitSDB.setLast_update_date(new Date());

        return requestPermitSignature.save(requestPermitSDB);
    }

    @Override
    public Boolean deleteRequestPermitSignature(Long id) {
        RequestPermitSignature requestPermitSDB = getRequestPermitSignature(id);
        if(null == requestPermitSDB){
            return false;
        }

        requestPermitSignature.deleteById(id);
        return true;
    }
}
