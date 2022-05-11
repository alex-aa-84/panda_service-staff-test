package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.DocumentType;

import java.util.List;

public interface DocumentTypeService {
    public List<DocumentType> listAllDocumentType();
    public DocumentType getDocumentType(Long id);

    public DocumentType createDocumentType(DocumentType documentType, Long userId);
    public DocumentType updateDocumentType(DocumentType documentType, Long userId);
    public DocumentType deleteDocumentType(Long id, Long userId);
}
