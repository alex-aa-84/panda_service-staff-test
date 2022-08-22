package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.Document;
import wwf.org.staff.repository.DocumentRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> listAllDocument() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocument(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    @Override
    public Document createDocument(Document document) {
        document.setStatus("CREATED");
        document.setCreation_date(new Date());
        document.setLast_update_date(new Date());

        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(Document document) {
        Document documentDB = getDocument(document.getId());
        if(null == documentDB){
            return null;
        }

        documentDB.setUserId(document.getUserId());
        documentDB.setDocumentType(document.getDocumentType());
        documentDB.setDocument(document.getDocument());
        documentDB.setExpirationDate(document.getExpirationDate());
        documentDB.setDescription(document.getDescription());

        documentDB.setAttribute1(document.getAttribute1());
        documentDB.setAttribute2(document.getAttribute2());
        documentDB.setAttribute3(document.getAttribute3());
        documentDB.setAttribute4(document.getAttribute4());
        documentDB.setAttribute5(document.getAttribute5());
        documentDB.setAttribute6(document.getAttribute6());
        documentDB.setAttribute7(document.getAttribute7());
        documentDB.setAttribute8(document.getAttribute8());
        documentDB.setAttribute9(document.getAttribute9());
        documentDB.setAttribute10(document.getAttribute10());

        documentDB.setStatus(document.getStatus());

        documentDB.setLast_update_by(document.getLast_update_by());
        documentDB.setLast_update_date(new Date());

        return documentRepository.save(documentDB);
    }

    @Override
    public Boolean deleteDocument(Long id) {
        Document documentDB = getDocument(id);
        if(null == documentDB){
            return false;
        }

        documentRepository.deleteById(id);
        return true;
    }

    @Override
    public Document findByDocument(String document) {
        return documentRepository.findByDocument(document);
    }

    @Override
    public List<Document> findByUserId(Long id) {
        // TODO Auto-generated method stub
        return documentRepository.findByUserId(id);
    }
}
