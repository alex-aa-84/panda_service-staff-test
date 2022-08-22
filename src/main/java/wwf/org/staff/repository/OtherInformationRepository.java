package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.OtherInformation;

public interface OtherInformationRepository extends JpaRepository<OtherInformation, Long> {
    public List<OtherInformation> findByUserId(Long id);
}
