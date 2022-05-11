package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Document;
import wwf.org.stafftest.repository.DocumentRepository;

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
    public Document createDocument(Document document, Long userId) {
        document.setStatus("CREATED");
        document.setCreate_by(userId);
        document.setCreation_date(new Date());
        document.setLast_update_by(userId);
        document.setLast_update_date(new Date());

        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(Document document, Long userId) {
        Document documentDB = getDocument(document.getId());
        if(null == documentDB){
            return null;
        }

        document.setLast_update_by(userId);
        document.setLast_update_date(new Date());

        return documentRepository.save(document);
    }

    @Override
    public Document deleteDocument(Long id, Long userId) {
        Document documentDB = getDocument(id);
        if(null == documentDB){
            return null;
        }

        documentDB.setStatus("DELETED");
        documentDB.setLast_update_by(userId);
        documentDB.setLast_update_date(new Date());

        return documentRepository.save(documentDB);
    }
}
