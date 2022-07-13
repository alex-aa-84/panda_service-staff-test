package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.RequestPermitType;
import wwf.org.staff.repository.RequestPermitTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestPermitTypeServiceImpl implements RequestPermitTypeService {

    @Autowired
    private RequestPermitTypeRepository requestPermitTypeRepository;

    @Override
    public List<RequestPermitType> listAllRequestPermitType() {
        return requestPermitTypeRepository.findAll();
    }

    @Override
    public RequestPermitType getRequestPermitType(Long id) {
        return requestPermitTypeRepository.findById(id).orElse(null);
    }

    @Override
    public RequestPermitType createRequestPermitType(RequestPermitType requestPermitType) {
        requestPermitType.setStatus("CREATED");
        requestPermitType.setCreation_date(new Date());
        requestPermitType.setLast_update_date(new Date());

        return requestPermitTypeRepository.save(requestPermitType);
    }

    @Override
    public RequestPermitType updateRequestPermitType(RequestPermitType requestPermitType) {
        RequestPermitType requestPermitTypeDB = getRequestPermitType(requestPermitType.getId());
        if(null == requestPermitTypeDB){
            return null;
        }

        requestPermitTypeDB.setName(requestPermitType.getName());
        requestPermitTypeDB.setDescription(requestPermitType.getDescription());

        requestPermitTypeDB.setAttribute1(requestPermitType.getAttribute1());
        requestPermitTypeDB.setAttribute2(requestPermitType.getAttribute2());
        requestPermitTypeDB.setAttribute3(requestPermitType.getAttribute3());
        requestPermitTypeDB.setAttribute4(requestPermitType.getAttribute4());
        requestPermitTypeDB.setAttribute5(requestPermitType.getAttribute5());
        requestPermitTypeDB.setAttribute6(requestPermitType.getAttribute6());
        requestPermitTypeDB.setAttribute7(requestPermitType.getAttribute7());
        requestPermitTypeDB.setAttribute8(requestPermitType.getAttribute8());
        requestPermitTypeDB.setAttribute9(requestPermitType.getAttribute9());
        requestPermitTypeDB.setAttribute10(requestPermitType.getAttribute10());

        requestPermitTypeDB.setStatus(requestPermitType.getStatus());

        requestPermitTypeDB.setLast_update_by(requestPermitType.getLast_update_by());
        requestPermitTypeDB.setLast_update_date(new Date());

        return requestPermitTypeRepository.save(requestPermitTypeDB);
    }

    @Override
    public Boolean deleteRequestPermitType(Long id) {
        RequestPermitType requestPermitTypeDB = getRequestPermitType(id);
        if(null == requestPermitTypeDB){
            return false;
        }

        requestPermitTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public RequestPermitType findByName(String name) {
        return requestPermitTypeRepository.findByName(name);
    }

}
