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
    public OtherInformationType createOtherInformationType(OtherInformationType otherInformationType, Long userId) {
        otherInformationType.setStatus("CREATED");
        otherInformationType.setCreate_by(userId);
        otherInformationType.setCreation_date(new Date());
        otherInformationType.setLast_update_by(userId);
        otherInformationType.setLast_update_date(new Date());

        return otherInformationTypeRepository.save(otherInformationType);
    }

    @Override
    public OtherInformationType updateOtherInformationType(OtherInformationType otherInformationType, Long userId) {
        OtherInformationType otherInformationTypeDB = getOtherInformationType(otherInformationType.getId());
        if(null == otherInformationTypeDB){
            return null;
        }

        otherInformationType.setLast_update_by(userId);
        otherInformationType.setLast_update_date(new Date());

        return otherInformationTypeRepository.save(otherInformationType);
    }

    @Override
    public OtherInformationType deleteOtherInformationType(Long id, Long userId) {
        OtherInformationType otherInformationTypeDB = getOtherInformationType(id);
        if(null == otherInformationTypeDB){
            return null;
        }

        otherInformationTypeDB.setStatus("DELETED");
        otherInformationTypeDB.setLast_update_by(userId);
        otherInformationTypeDB.setLast_update_date(new Date());

        return otherInformationTypeRepository.save(otherInformationTypeDB);
    }
}
