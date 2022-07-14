package wwf.org.staff.service;

import wwf.org.staff.entity.AdditionalOrganizationType;

import java.util.List;

public interface AdditionalOrganizationTypeService {

    public List<AdditionalOrganizationType> listAllAdditionalOrganizationType();
    public AdditionalOrganizationType getAdditionalOrganizationType(Long id);

    public AdditionalOrganizationType createAdditionalOrganizationType(AdditionalOrganizationType address);
    public AdditionalOrganizationType updateAdditionalOrganizationType(AdditionalOrganizationType address);
    public Boolean deleteAdditionalOrganizationType(Long id);

    public AdditionalOrganizationType findByName(String name);

}
