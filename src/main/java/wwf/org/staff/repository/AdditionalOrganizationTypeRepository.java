package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.AdditionalOrganizationType;
import wwf.org.staff.entity.AddressType;

public interface AdditionalOrganizationTypeRepository extends JpaRepository<AdditionalOrganizationType, Long> {
    public AdditionalOrganizationType findByName(String name);
}
