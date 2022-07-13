package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.AttachmentFile;

public interface AttachmentFileRepository extends JpaRepository<AttachmentFile, Long> {
}
