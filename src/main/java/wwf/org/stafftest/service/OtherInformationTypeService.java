package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.OtherInformationType;

import java.util.List;

public interface OtherInformationTypeService {
    public List<OtherInformationType> listAllOtherInformationType();
    public OtherInformationType getOtherInformationType(Long id);

    public OtherInformationType createOtherInformationType(OtherInformationType otherInformationType, Long userId);
    public OtherInformationType updateOtherInformationType(OtherInformationType otherInformationType, Long userId);
    public OtherInformationType deleteOtherInformationType(Long id, Long userId);
}
