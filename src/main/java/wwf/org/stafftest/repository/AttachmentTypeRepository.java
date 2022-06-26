package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.AttachmentType;

public interface AttachmentTypeRepository extends JpaRepository<AttachmentType, Long> {
    public AttachmentType findByAttachmentType(String attachmentType);
}
