package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
