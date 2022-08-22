package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.RequestPermitHeader;

public interface RequestPermitHeaderRepository extends JpaRepository<RequestPermitHeader, Long> {

    public RequestPermitHeader findByNumberSolict(String numberSolict);
    public List<RequestPermitHeader> findByUserId(Long userId);

}
