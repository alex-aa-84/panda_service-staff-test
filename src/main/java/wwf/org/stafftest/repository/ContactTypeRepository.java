package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.ContactType;

public interface ContactTypeRepository extends JpaRepository<ContactType, Long> {
    public ContactType findByContactType(String contactType);
}
