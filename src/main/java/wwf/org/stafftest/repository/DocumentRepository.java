package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    public Document findByDocument(String document);
}
