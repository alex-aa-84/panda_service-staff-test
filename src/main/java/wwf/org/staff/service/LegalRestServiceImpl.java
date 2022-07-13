package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.LegalRest;
import wwf.org.staff.repository.LegalRestRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LegalRestServiceImpl implements LegalRestService{

    @Autowired
    private LegalRestRepository legalRestRepository;

    @Override
    public List<LegalRest> listAllLegalRest() {
        return legalRestRepository.findAll();
    }

    @Override
    public LegalRest getLegalRest(Long id) {
        return legalRestRepository.findById(id).orElse(null);
    }

    @Override
    public LegalRest createLegalRest(LegalRest legalRest) {
        legalRest.setStatus("CREATED");
        legalRest.setCreation_date(new Date());
        legalRest.setLast_update_date(new Date());

        return legalRestRepository.save(legalRest);
    }

    @Override
    public LegalRest updateLegalRest(LegalRest legalRest) {
        LegalRest legalRestDB = getLegalRest(legalRest.getId());
        if(null == legalRestDB){
            return null;
        }

        legalRestDB.setUserId(legalRest.getUserId());
        legalRestDB.setStartDate(legalRest.getStartDate());
        legalRestDB.setEndDate(legalRest.getEndDate());
        legalRestDB.setAntiquity(legalRest.getAntiquity());
        legalRestDB.setAccrued(legalRest.getAccrued());
        legalRestDB.setUsed(legalRest.getUsed());
        legalRestDB.setObservation(legalRest.getObservation());

        legalRestDB.setAttribute1(legalRest.getAttribute1());
        legalRestDB.setAttribute2(legalRest.getAttribute2());
        legalRestDB.setAttribute3(legalRest.getAttribute3());
        legalRestDB.setAttribute4(legalRest.getAttribute4());
        legalRestDB.setAttribute5(legalRest.getAttribute5());
        legalRestDB.setAttribute6(legalRest.getAttribute6());
        legalRestDB.setAttribute7(legalRest.getAttribute7());
        legalRestDB.setAttribute8(legalRest.getAttribute8());
        legalRestDB.setAttribute9(legalRest.getAttribute9());
        legalRestDB.setAttribute10(legalRest.getAttribute10());

        legalRestDB.setStatus(legalRest.getStatus());

        legalRestDB.setLast_update_by(legalRest.getLast_update_by());
        legalRestDB.setLast_update_date(new Date());

        return legalRestRepository.save(legalRestDB);
    }

    @Override
    public Boolean deleteLegalRest(Long id) {
        LegalRest legalRestDB = getLegalRest(id);
        if(null == legalRestDB){
            return false;
        }

        legalRestRepository.deleteById(id);
        return true;
    }

    @Override
    public LegalRest findByUserIdAndStartDateAndEndDate(Long userId, Date startDate, Date endDate) {
        return legalRestRepository.findByUserIdAndStartDateAndEndDate(userId, startDate, endDate);
    }

}
