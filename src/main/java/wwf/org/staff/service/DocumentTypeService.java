package wwf.org.staff.service;

import wwf.org.staff.entity.DocumentType;

import java.util.List;

public interface DocumentTypeService {
    public List<DocumentType> listAllDocumentType();
    public DocumentType getDocumentType(Long id);

    public DocumentType createDocumentType(DocumentType documentType);
    public DocumentType updateDocumentType(DocumentType documentType);
    public Boolean deleteDocumentType(Long id);
    public DocumentType findByDocumentType(String documentType);
}
