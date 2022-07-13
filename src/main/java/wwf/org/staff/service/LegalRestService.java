package wwf.org.staff.service;

import wwf.org.staff.entity.LegalRest;

import java.util.Date;
import java.util.List;

public interface LegalRestService {
    public List<LegalRest> listAllLegalRest();
    public LegalRest getLegalRest(Long id);

    public LegalRest createLegalRest(LegalRest legalRest);
    public LegalRest updateLegalRest(LegalRest legalRest);
    public Boolean deleteLegalRest(Long id);

    public LegalRest findByUserIdAndStartDateAndEndDate(Long userId, Date startDate, Date endDate);
}
