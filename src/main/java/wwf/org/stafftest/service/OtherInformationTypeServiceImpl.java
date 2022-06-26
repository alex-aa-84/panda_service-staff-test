package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.OtherInformationType;
import wwf.org.stafftest.repository.OtherInformationTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OtherInformationTypeServiceImpl implements OtherInformationTypeService {

    @Autowired
    private OtherInformationTypeRepository otherInformationTypeRepository;

    @Override
    public List<OtherInformationType> listAllOtherInformationType() {
        return otherInformationTypeRepository.findAll();
    }

    @Override
    public OtherInformationType getOtherInformationType(Long id) {
        return otherInformationTypeRepository.findById(id).orElse(null);
    }

    @Override
    public OtherInformationType createOtherInformationType(OtherInformationType otherInformationType) {
        otherInformationType.setStatus("CREATED");
        otherInformationType.setCreation_date(new Date());
        otherInformationType.setLast_update_date(new Date());

        return otherInformationTypeRepository.save(otherInformationType);
    }

    @Override
    public OtherInformationType updateOtherInformationType(OtherInformationType otherInformationType) {
        OtherInformationType otherInformationTypeDB = getOtherInformationType(otherInformationType.getId());
        if(null == otherInformationTypeDB){
            return null;
        }

        otherInformationTypeDB.setOtherInformationType(otherInformationType.getOtherInformationType());
        otherInformationTypeDB.setDescription(otherInformationType.getDescription());

        otherInformationTypeDB.setAttribute1(otherInformationType.getAttribute1());
        otherInformationTypeDB.setAttribute2(otherInformationType.getAttribute2());
        otherInformationTypeDB.setAttribute3(otherInformationType.getAttribute3());
        otherInformationTypeDB.setAttribute4(otherInformationType.getAttribute4());
        otherInformationTypeDB.setAttribute5(otherInformationType.getAttribute5());
        otherInformationTypeDB.setAttribute6(otherInformationType.getAttribute6());
        otherInformationTypeDB.setAttribute7(otherInformationType.getAttribute7());
        otherInformationTypeDB.setAttribute8(otherInformationType.getAttribute8());
        otherInformationTypeDB.setAttribute9(otherInformationType.getAttribute9());
        otherInformationTypeDB.setAttribute10(otherInformationType.getAttribute10());

        otherInformationTypeDB.setStatus(otherInformationType.getStatus());

        otherInformationTypeDB.setLast_update_by(otherInformationType.getLast_update_by());
        otherInformationTypeDB.setLast_update_date(new Date());

        return otherInformationTypeRepository.save(otherInformationTypeDB);
    }

    @Override
    public Boolean deleteOtherInformationType(Long id) {
        OtherInformationType otherInformationTypeDB = getOtherInformationType(id);
        if(null == otherInformationTypeDB){
            return false;
        }

        otherInformationTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public OtherInformationType findByOtherInformationType(String otherInformationType) {
        return otherInformationTypeRepository.findByOtherInformationType(otherInformationType);
    }
}
