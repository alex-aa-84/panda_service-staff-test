package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.DocumentType;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
}
