package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.OtherInformationType;

public interface OtherInformationTypeRepository extends JpaRepository<OtherInformationType, Long> {
    public OtherInformationType findByOtherInformationType(String otherInformationType);
}
