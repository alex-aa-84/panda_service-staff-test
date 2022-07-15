package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.AdditionalOrganization;
import wwf.org.staff.entity.AdditionalOrganizationType;

public interface AdditionalOrganizationRepository extends JpaRepository<AdditionalOrganization, Long> {
    public AdditionalOrganization findByTenantIdAndAdditionalOrganizationTypeIdAndFromTimeAndUntilTimeAndFromMonthAndUntilMonthAndValue(
            Long tenantId, Long additionalOrganizationTypeId, Integer fromTime, Integer untilTime, Integer fromMonth, Integer untilMonth, Integer value
    );
}
