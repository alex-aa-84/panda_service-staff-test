package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
