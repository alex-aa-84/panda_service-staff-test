package wwf.org.staff.service;

import wwf.org.staff.entity.AdditionalOrganization;

import java.util.List;

public interface AdditionalOrganizationService {
    public List<AdditionalOrganization> listAllAdditionalOrganization();
    public AdditionalOrganization getAdditionalOrganization(Long id);

    public AdditionalOrganization createAdditionalOrganization(AdditionalOrganization address);
    public AdditionalOrganization updateAdditionalOrganization(AdditionalOrganization address);
    public Boolean deleteAdditionalOrganization(Long id);

    public AdditionalOrganization findByTenantIdAndadditionalOrganizationTypeIdAndFromTimeAndUntilTimeAndFromMonthAndUntilMonthAndValue(
            Long tenantId, Long additionalOrganizationTypeId, Integer fromTime, Integer untilTime, Integer fromMonth, Integer untilMonth, Integer value
    );
}
