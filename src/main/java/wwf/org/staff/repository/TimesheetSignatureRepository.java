package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetSignature;

public interface TimesheetSignatureRepository extends JpaRepository<TimesheetSignature, Long> {

}
