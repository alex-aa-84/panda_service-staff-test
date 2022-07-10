package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.PersonalInformation;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {
    public PersonalInformation findByUserId(Long userId);
}
