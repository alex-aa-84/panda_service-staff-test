package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Attachment;
import wwf.org.stafftest.entity.AttachmentType;
import wwf.org.stafftest.repository.AttachmentTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentTypeServiceImpl implements AttachmentTypeService{

    @Autowired
    private AttachmentTypeRepository attachmentTypeRepository;


    @Override
    public List<AttachmentType> listAllAttachmentType() {
        return attachmentTypeRepository.findAll();
    }

    @Override
    public AttachmentType getAttachmentType(Long id) {
        return attachmentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public AttachmentType createAttachmentType(AttachmentType attachmentType, Long userId) {
        attachmentType.setStatus("CREATED");
        attachmentType.setCreate_by(userId);
        attachmentType.setCreation_date(new Date());
        attachmentType.setLast_update_by(userId);
        attachmentType.setLast_update_date(new Date());

        return attachmentTypeRepository.save(attachmentType);
    }

    @Override
    public AttachmentType updateAttachmentType(AttachmentType attachmentType, Long userId) {
        AttachmentType attachmentTypeBD = getAttachmentType(attachmentType.getId());
        if(null == attachmentTypeBD){
            return null;
        }

        attachmentType.setLast_update_by(userId);
        attachmentType.setLast_update_date(new Date());

        return attachmentTypeRepository.save(attachmentType);
    }

    @Override
    public AttachmentType deleteAttachmentType(Long id, Long userId) {
        AttachmentType attachmentTypeBD = getAttachmentType(id);
        if(null == attachmentTypeBD){
            return null;
        }

        attachmentTypeBD.setStatus("DELETED");
        attachmentTypeBD.setLast_update_by(userId);
        attachmentTypeBD.setLast_update_date(new Date());

        return attachmentTypeRepository.save(attachmentTypeBD);
    }
}
