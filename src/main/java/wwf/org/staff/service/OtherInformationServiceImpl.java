package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.OtherInformation;
import wwf.org.staff.repository.OtherInformationRepository;
import wwf.org.staff.serviceApi.MD5Util;

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
    public OtherInformation createOtherInformation(OtherInformation otherInformation) {
        otherInformation.setStatus("CREATED");
        otherInformation.setCreation_date(new Date());
        otherInformation.setLast_update_date(new Date());

        String md5 = MD5Util.string2MD5(otherInformation.toString());
        otherInformation.setCtrlMd5(md5);

        return otherInformationRepository.save(otherInformation);
    }

    @Override
    public OtherInformation updateOtherInformation(OtherInformation otherInformation) {
        OtherInformation otherInformationDB = getOtherInformation(otherInformation.getId());
        if(null == otherInformationDB){
            return null;
        }

        otherInformationDB.setUserId(otherInformation.getUserId());
        otherInformationDB.setOtherInformationType(otherInformation.getOtherInformationType());
        otherInformationDB.setDescription1(otherInformation.getDescription1());
        otherInformationDB.setDescription2(otherInformation.getDescription2());

        otherInformationDB.setAttribute1(otherInformation.getAttribute1());
        otherInformationDB.setAttribute2(otherInformation.getAttribute2());
        otherInformationDB.setAttribute3(otherInformation.getAttribute3());
        otherInformationDB.setAttribute4(otherInformation.getAttribute4());
        otherInformationDB.setAttribute5(otherInformation.getAttribute5());
        otherInformationDB.setAttribute6(otherInformation.getAttribute6());
        otherInformationDB.setAttribute7(otherInformation.getAttribute7());
        otherInformationDB.setAttribute8(otherInformation.getAttribute8());
        otherInformationDB.setAttribute9(otherInformation.getAttribute9());
        otherInformationDB.setAttribute10(otherInformation.getAttribute10());

        otherInformationDB.setStatus(otherInformation.getStatus());

        otherInformationDB.setLast_update_by(otherInformation.getLast_update_by());
        otherInformationDB.setLast_update_date(new Date());

        return otherInformationRepository.save(otherInformationDB);
    }

    @Override
    public Boolean deleteOtherInformation(Long id) {
        OtherInformation otherInformationDB = getOtherInformation(id);
        if(null == otherInformationDB){
            return false;
        }

        otherInformationRepository.deleteById(id);
        return true;
    }

    @Override
    public List<OtherInformation> findByUserId(Long id) {
        // TODO Auto-generated method stub
        return otherInformationRepository.findByUserId(id);
    }
}
