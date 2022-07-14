package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.RequestType;
import wwf.org.staff.repository.RequestPermitTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestPermitTypeServiceImpl implements RequestPermitTypeService {

    @Autowired
    private RequestPermitTypeRepository requestPermitTypeRepository;

    @Override
    public List<RequestType> listAllRequestPermitType() {
        return requestPermitTypeRepository.findAll();
    }

    @Override
    public RequestType getRequestPermitType(Long id) {
        return requestPermitTypeRepository.findById(id).orElse(null);
    }

    @Override
    public RequestType createRequestPermitType(RequestType requestType) {
        requestType.setStatus("CREATED");
        requestType.setCreation_date(new Date());
        requestType.setLast_update_date(new Date());

        return requestPermitTypeRepository.save(requestType);
    }

    @Override
    public RequestType updateRequestPermitType(RequestType requestType) {
        RequestType requestTypeDB = getRequestPermitType(requestType.getId());
        if(null == requestTypeDB){
            return null;
        }

        requestTypeDB.setName(requestType.getName());
        requestTypeDB.setDescription(requestType.getDescription());

        requestTypeDB.setAttribute1(requestType.getAttribute1());
        requestTypeDB.setAttribute2(requestType.getAttribute2());
        requestTypeDB.setAttribute3(requestType.getAttribute3());
        requestTypeDB.setAttribute4(requestType.getAttribute4());
        requestTypeDB.setAttribute5(requestType.getAttribute5());
        requestTypeDB.setAttribute6(requestType.getAttribute6());
        requestTypeDB.setAttribute7(requestType.getAttribute7());
        requestTypeDB.setAttribute8(requestType.getAttribute8());
        requestTypeDB.setAttribute9(requestType.getAttribute9());
        requestTypeDB.setAttribute10(requestType.getAttribute10());

        requestTypeDB.setStatus(requestType.getStatus());

        requestTypeDB.setLast_update_by(requestType.getLast_update_by());
        requestTypeDB.setLast_update_date(new Date());

        return requestPermitTypeRepository.save(requestTypeDB);
    }

    @Override
    public Boolean deleteRequestPermitType(Long id) {
        RequestType requestTypeDB = getRequestPermitType(id);
        if(null == requestTypeDB){
            return false;
        }

        requestPermitTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public RequestType findByName(String name) {
        return requestPermitTypeRepository.findByName(name);
    }

}
