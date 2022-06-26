package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.CivilStatus;
import wwf.org.stafftest.repository.CivilStatusRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CivilStatusServiceImpl implements CivilStatusService {

    @Autowired
    private CivilStatusRepository civilStatusRepository;

    @Override
    public List<CivilStatus> listAllCivilStatus() {
        return civilStatusRepository.findAll();
    }

    @Override
    public CivilStatus getCivilStatus(Long id) {
        return civilStatusRepository.findById(id).orElse(null);
    }

    @Override
    public CivilStatus createCivilStatus(CivilStatus civilStatus) {
        civilStatus.setStatus("CREATED");
        civilStatus.setCreation_date(new Date());
        civilStatus.setLast_update_date(new Date());

        return civilStatusRepository.save(civilStatus);
    }

    @Override
    public CivilStatus updateCivilStatus(CivilStatus civilStatus) {
        CivilStatus civilStatusDB = getCivilStatus(civilStatus.getId());
        if(null == civilStatusDB){
            return null;
        }

        civilStatusDB.setCivilStatus(civilStatus.getCivilStatus());
        civilStatusDB.setDescription(civilStatus.getDescription());

        civilStatusDB.setAttribute1(civilStatus.getAttribute1());
        civilStatusDB.setAttribute2(civilStatus.getAttribute2());
        civilStatusDB.setAttribute3(civilStatus.getAttribute3());
        civilStatusDB.setAttribute4(civilStatus.getAttribute4());
        civilStatusDB.setAttribute5(civilStatus.getAttribute5());
        civilStatusDB.setAttribute6(civilStatus.getAttribute6());
        civilStatusDB.setAttribute7(civilStatus.getAttribute7());
        civilStatusDB.setAttribute8(civilStatus.getAttribute8());
        civilStatusDB.setAttribute9(civilStatus.getAttribute9());
        civilStatusDB.setAttribute10(civilStatus.getAttribute10());

        civilStatusDB.setStatus(civilStatus.getStatus());

        civilStatusDB.setLast_update_by(civilStatus.getLast_update_by());
        civilStatusDB.setLast_update_date(new Date());

        return civilStatusRepository.save(civilStatusDB);
    }

    @Override
    public Boolean deleteCivilStatus(Long id) {
        CivilStatus civilStatusDB = getCivilStatus(id);
        if(null == civilStatusDB){
            return false;
        }

        civilStatusRepository.deleteById(id);
        return true;
    }

    @Override
    public CivilStatus findByCivilStatus(String civilStatus) {
        return civilStatusRepository.findByCivilStatus(civilStatus);
    }
}
