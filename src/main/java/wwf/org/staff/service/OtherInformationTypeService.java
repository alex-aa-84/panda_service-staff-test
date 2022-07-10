package wwf.org.staff.service;

import wwf.org.staff.entity.OtherInformationType;

import java.util.List;

public interface OtherInformationTypeService {
    public List<OtherInformationType> listAllOtherInformationType();
    public OtherInformationType getOtherInformationType(Long id);

    public OtherInformationType createOtherInformationType(OtherInformationType otherInformationType);
    public OtherInformationType updateOtherInformationType(OtherInformationType otherInformationType);
    public Boolean deleteOtherInformationType(Long id);
    public OtherInformationType findByOtherInformationType(String otherInformationType);
}
