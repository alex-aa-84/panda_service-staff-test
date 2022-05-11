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
    public CivilStatus createCivilStatus(CivilStatus civilStatus, Long userId) {
        civilStatus.setStatus("CREATED");
        civilStatus.setCreate_by(userId);
        civilStatus.setCreation_date(new Date());
        civilStatus.setLast_update_by(userId);
        civilStatus.setLast_update_date(new Date());

        return civilStatusRepository.save(civilStatus);
    }

    @Override
    public CivilStatus updateCivilStatus(CivilStatus civilStatus, Long userId) {
        CivilStatus civilStatusDB = getCivilStatus(civilStatus.getId());
        if(null == civilStatusDB){
            return null;
        }

        civilStatus.setLast_update_by(userId);
        civilStatus.setLast_update_date(new Date());

        return civilStatusRepository.save(civilStatus);
    }

    @Override
    public CivilStatus deleteCivilStatus(Long id, Long userId) {
        CivilStatus civilStatusDB = getCivilStatus(id);
        if(null == civilStatusDB){
            return null;
        }

        civilStatusDB.setStatus("DELETED");
        civilStatusDB.setLast_update_by(userId);
        civilStatusDB.setLast_update_date(new Date());

        return civilStatusRepository.save(civilStatusDB);
    }
}
