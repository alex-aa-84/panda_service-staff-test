package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Document;

import java.util.List;

public interface DocumentService {
    public List<Document> listAllDocument();
    public Document getDocument(Long id);

    public Document createDocument(Document document, Long userId);
    public Document updateDocument(Document document, Long userId);
    public Document deleteDocument(Long id, Long userId);
}