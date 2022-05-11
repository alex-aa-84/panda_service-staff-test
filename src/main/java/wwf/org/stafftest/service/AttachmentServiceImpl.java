package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Attachment;
import wwf.org.stafftest.repository.AttachmentRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService{

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public List<Attachment> listAllAttachment() {
        return attachmentRepository.findAll();
    }

    @Override
    public Attachment getAttachment(Long id) {
        return attachmentRepository.findById(id).orElse(null);
    }

    @Override
    public Attachment createAttachment(Attachment attachment, Long userId) {
        attachment.setStatus("CREATED");
        attachment.setCreate_by(userId);
        attachment.setCreation_date(new Date());
        attachment.setLast_update_by(userId);
        attachment.setLast_update_date(new Date());

        return attachmentRepository.save(attachment);
    }

    @Override
    public Attachment updateAttachment(Attachment attachment, Long userId) {
        Attachment attachmentDB = getAttachment(attachment.getId());
        if(null == attachmentDB){
            return null;
        }

        attachment.setLast_update_by(userId);
        attachment.setLast_update_date(new Date());

        return attachmentRepository.save(attachment);
    }

    @Override
    public Attachment deleteAttachment(Long id, Long userId) {
        Attachment attachmentDB = getAttachment(id);
        if(null == attachmentDB){
            return null;
        }

        attachmentDB.setStatus("DELETED");
        attachmentDB.setLast_update_by(userId);
        attachmentDB.setLast_update_date(new Date());

        return attachmentRepository.save(attachmentDB);
    }
}
