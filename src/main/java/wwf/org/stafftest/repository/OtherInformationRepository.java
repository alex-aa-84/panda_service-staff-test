package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.OtherInformation;

public interface OtherInformationRepository extends JpaRepository<OtherInformation, Long> {
}
