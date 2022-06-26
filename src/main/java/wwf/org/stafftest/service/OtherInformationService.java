package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.OtherInformation;

import java.util.List;

public interface OtherInformationService {
    public List<OtherInformation> listAllOtherInformation();
    public OtherInformation getOtherInformation(Long id);

    public OtherInformation createOtherInformation(OtherInformation otherInformation);
    public OtherInformation updateOtherInformation(OtherInformation otherInformation);
    public Boolean deleteOtherInformation(Long id);
}
