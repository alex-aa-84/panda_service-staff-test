package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    public Document findByDocument(String document);
    public List<Document> findByUserId(Long id);
}
