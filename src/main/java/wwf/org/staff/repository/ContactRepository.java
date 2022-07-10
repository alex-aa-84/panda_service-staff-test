package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
