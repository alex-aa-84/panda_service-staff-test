package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.ContactType;

public interface ContactTypeRepository extends JpaRepository<ContactType, Long> {
    public ContactType findByContactType(String contactType);
}
