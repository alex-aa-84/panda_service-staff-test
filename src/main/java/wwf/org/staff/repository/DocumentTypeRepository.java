package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.DocumentType;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    public DocumentType findByName(String name);
}
