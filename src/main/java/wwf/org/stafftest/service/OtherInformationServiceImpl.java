package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.OtherInformation;
import wwf.org.stafftest.repository.OtherInformationRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OtherInformationServiceImpl implements OtherInformationService {

    @Autowired
    private OtherInformationRepository otherInformationRepository;

    @Override
    public List<OtherInformation> listAllOtherInformation() {
        return otherInformationRepository.findAll();
    }

    @Override
    public OtherInformation getOtherInformation(Long id) {
        return otherInformationRepository.findById(id).orElse(null);
    }

    @Override
    public OtherInformation createOtherInformation(OtherInformation otherInformation, Long userId) {
        otherInformation.setStatus("CREATED");
        otherInformation.setCreate_by(userId);
        otherInformation.setCreation_date(new Date());
        otherInformation.setLast_update_by(userId);
        otherInformation.setLast_update_date(new Date());

        return otherInformationRepository.save(otherInformation);
    }

    @Override
    public OtherInformation updateOtherInformation(OtherInformation otherInformation, Long userId) {
        OtherInformation otherInformationDB = getOtherInformation(otherInformation.getId());
        if(null == otherInformationDB){
            return null;
        }

        otherInformation.setLast_update_by(userId);
        otherInformation.setLast_update_date(new Date());

        return otherInformationRepository.save(otherInformation);
    }

    @Override
    public OtherInformation deleteOtherInformation(Long id, Long userId) {
        OtherInformation otherInformationDB = getOtherInformation(id);
        if(null == otherInformationDB){
            return null;
        }

        otherInformationDB.setStatus("DELETED");
        otherInformationDB.setLast_update_by(userId);
        otherInformationDB.setLast_update_date(new Date());

        return otherInformationRepository.save(otherInformationDB);
    }
}
