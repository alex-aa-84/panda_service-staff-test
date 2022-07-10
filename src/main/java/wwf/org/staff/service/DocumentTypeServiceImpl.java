package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.DocumentType;
import wwf.org.staff.repository.DocumentTypeRepository;

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
    public DocumentType createDocumentType(DocumentType documentType) {
        documentType.setStatus("CREATED");
        documentType.setCreation_date(new Date());
        documentType.setLast_update_date(new Date());

        return documentTypeRepository.save(documentType);
    }

    @Override
    public DocumentType updateDocumentType(DocumentType documentType) {
        DocumentType documentTypeDB = getDocumentType(documentType.getId());
        if(null == documentTypeDB){
            return null;
        }

        documentTypeDB.setDocumentType(documentType.getDocumentType());
        documentTypeDB.setDescription(documentType.getDescription());

        documentTypeDB.setAttribute1(documentType.getAttribute1());
        documentTypeDB.setAttribute2(documentType.getAttribute2());
        documentTypeDB.setAttribute3(documentType.getAttribute3());
        documentTypeDB.setAttribute4(documentType.getAttribute4());
        documentTypeDB.setAttribute5(documentType.getAttribute5());
        documentTypeDB.setAttribute6(documentType.getAttribute6());
        documentTypeDB.setAttribute7(documentType.getAttribute7());
        documentTypeDB.setAttribute8(documentType.getAttribute8());
        documentTypeDB.setAttribute9(documentType.getAttribute9());
        documentTypeDB.setAttribute10(documentType.getAttribute10());

        documentTypeDB.setStatus(documentType.getStatus());

        documentTypeDB.setLast_update_by(documentType.getLast_update_by());
        documentTypeDB.setLast_update_date(new Date());

        return documentTypeRepository.save(documentTypeDB);
    }

    @Override
    public Boolean deleteDocumentType(Long id) {
        DocumentType documentTypeDB = getDocumentType(id);
        if(null == documentTypeDB){
            return false;
        }

        documentTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public DocumentType findByDocumentType(String documentType) {
        return documentTypeRepository.findByDocumentType(documentType);
    }
}
