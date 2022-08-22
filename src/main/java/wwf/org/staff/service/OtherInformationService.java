package wwf.org.staff.service;

import wwf.org.staff.entity.OtherInformation;

import java.util.List;

public interface OtherInformationService {
    public List<OtherInformation> listAllOtherInformation();
    public OtherInformation getOtherInformation(Long id);

    public OtherInformation createOtherInformation(OtherInformation otherInformation);
    public OtherInformation updateOtherInformation(OtherInformation otherInformation);
    public Boolean deleteOtherInformation(Long id);
    public List<OtherInformation> findByUserId(Long id);
}
