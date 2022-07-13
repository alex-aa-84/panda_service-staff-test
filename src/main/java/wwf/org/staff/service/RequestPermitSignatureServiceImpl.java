package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.RequestPermitSignature;
import wwf.org.staff.repository.RequestPermitSignatureRepository;

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
    public RequestPermitSignature createRequestPermitSignature(RequestPermitSignature relationship) {
        relationship.setStatus("CREATED");
        relationship.setCreation_date(new Date());
        relationship.setLast_update_date(new Date());

        return requestPermitSignature.save(relationship);
    }

    @Override
    public RequestPermitSignature updateRequestPermitSignature(RequestPermitSignature relationship) {
        RequestPermitSignature relationshipDB = getRequestPermitSignature(relationship.getId());
        if(null == relationshipDB){
            return null;
        }

        relationshipDB.setRequestPermitHeader(relationship.getRequestPermitHeader());
        relationshipDB.setWorkflowSteps(relationship.getWorkflowSteps());
        relationshipDB.setSignature(relationship.getSignature());
        relationshipDB.setUserId(relationship.getUserId());

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

        return requestPermitSignature.save(relationshipDB);
    }

    @Override
    public Boolean deleteRequestPermitSignature(Long id) {
        RequestPermitSignature relationshipDB = getRequestPermitSignature(id);
        if(null == relationshipDB){
            return false;
        }

        requestPermitSignature.deleteById(id);
        return true;
    }
}
