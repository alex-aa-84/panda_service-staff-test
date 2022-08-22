package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    public List<Contact> findByUserId(Long id);
}
