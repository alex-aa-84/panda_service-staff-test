package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.OtherInformation;

import java.util.List;

public interface OtherInformationService {
    public List<OtherInformation> listAllOtherInformation();
    public OtherInformation getOtherInformation(Long id);

    public OtherInformation createOtherInformation(OtherInformation otherInformation, Long userId);
    public OtherInformation updateOtherInformation(OtherInformation otherInformation, Long userId);
    public OtherInformation deleteOtherInformation(Long id, Long userId);
}
