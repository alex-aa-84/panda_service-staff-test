package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.AttachmentType;

public interface AttachmentTypeRepository extends JpaRepository<AttachmentType, Long> {
    public AttachmentType findByName(String name);
}
