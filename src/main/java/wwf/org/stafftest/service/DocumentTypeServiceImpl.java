package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.DocumentType;
import wwf.org.stafftest.repository.DocumentTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Override
    public List<DocumentType> listAllDocumentType() {
        return documentTypeRepository.findAll();
    }

    @Override
    public DocumentType getDocumentType(Long id) {
        return documentTypeRepository.getById(id);
    }

    @Override
    public DocumentType createDocumentType(DocumentType documentType, Long userId) {
        documentType.setStatus("CREATED");
        documentType.setCreate_by(userId);
        documentType.setCreation_date(new Date());
        documentType.setLast_update_by(userId);
        documentType.setLast_update_date(new Date());

        return documentTypeRepository.save(documentType);
    }

    @Override
    public DocumentType updateDocumentType(DocumentType documentType, Long userId) {
        DocumentType documentTypeDB = getDocumentType(documentType.getId());
        if(null == documentTypeDB){
            return null;
        }

        documentType.setLast_update_by(userId);
        documentType.setLast_update_date(new Date());

        return documentTypeRepository.save(documentType);
    }

    @Override
    public DocumentType deleteDocumentType(Long id, Long userId) {
        DocumentType documentTypeDB = getDocumentType(id);
        if(null == documentTypeDB){
            return null;
        }

        documentTypeDB.setStatus("DELETED");
        documentTypeDB.setLast_update_by(userId);
        documentTypeDB.setLast_update_date(new Date());

        return documentTypeRepository.save(documentTypeDB);
    }
}
