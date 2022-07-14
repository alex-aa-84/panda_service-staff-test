package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.RequestType;

public interface RequestPermitTypeRepository extends JpaRepository<RequestType, Long> {

    public RequestType findByName(String name);
}
