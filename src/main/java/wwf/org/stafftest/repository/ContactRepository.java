package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
