package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Profession;
import wwf.org.staff.entity.RequestPermitType;

public interface RequestPermitTypeRepository extends JpaRepository<RequestPermitType, Long> {

    public RequestPermitType findByName(String name);
}
