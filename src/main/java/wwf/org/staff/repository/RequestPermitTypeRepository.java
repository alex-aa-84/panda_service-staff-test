package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import wwf.org.staff.entity.RequestType;

public interface RequestPermitTypeRepository extends JpaRepository<RequestType, Long> {

    public RequestType findByName(String name);

    @Query("SELECT p FROM RequestType p where p.status != 'INACTIVE' order by p.orden")
    public List<RequestType> findActiveRequestTypes();
}
