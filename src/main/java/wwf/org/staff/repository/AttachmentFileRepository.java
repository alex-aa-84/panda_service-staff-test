package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.AttachmentFile;

public interface AttachmentFileRepository extends JpaRepository<AttachmentFile, Long> {
    public List<AttachmentFile> findByReferenceAndReferenceId(String reference, Long referenceId);
}
