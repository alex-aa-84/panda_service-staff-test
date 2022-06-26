package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.OtherInformationType;

import java.util.List;

public interface OtherInformationTypeService {
    public List<OtherInformationType> listAllOtherInformationType();
    public OtherInformationType getOtherInformationType(Long id);

    public OtherInformationType createOtherInformationType(OtherInformationType otherInformationType);
    public OtherInformationType updateOtherInformationType(OtherInformationType otherInformationType);
    public Boolean deleteOtherInformationType(Long id);
    public OtherInformationType findByOtherInformationType(String otherInformationType);
}
