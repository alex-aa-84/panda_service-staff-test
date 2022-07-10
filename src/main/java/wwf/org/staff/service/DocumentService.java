package wwf.org.staff.service;

import wwf.org.staff.entity.Document;

import java.util.List;

public interface DocumentService {
    public List<Document> listAllDocument();
    public Document getDocument(Long id);

    public Document createDocument(Document document);
    public Document updateDocument(Document document);
    public Boolean deleteDocument(Long id);
    public Document findByDocument(String document);
}
