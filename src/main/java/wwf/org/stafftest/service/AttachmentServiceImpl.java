package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.Attachment;
import wwf.org.stafftest.repository.AttachmentRepository;
import wwf.org.stafftest.serviceApi.MD5Util;

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
    public Attachment createAttachment(Attachment attachment) {
        attachment.setStatus("CREATED");
        attachment.setCreation_date(new Date());
        attachment.setLast_update_date(new Date());

        String md5 = MD5Util.string2MD5(attachment.toString());
        attachment.setCtrlMd5(md5);

        return attachmentRepository.save(attachment);
    }

    @Override
    public Attachment updateAttachment(Attachment attachment) {
        Attachment attachmentDB = getAttachment(attachment.getId());
        if(null == attachmentDB){
            return null;
        }

        attachmentDB.setUserId(attachment.getUserId());
        attachmentDB.setAttachmentType(attachment.getAttachmentType());
        attachmentDB.setImageConfig(attachment.getImageConfig());
        attachmentDB.setDescription(attachment.getDescription());

        attachmentDB.setAttribute1(attachment.getAttribute1());
        attachmentDB.setAttribute2(attachment.getAttribute2());
        attachmentDB.setAttribute3(attachment.getAttribute3());
        attachmentDB.setAttribute4(attachment.getAttribute4());
        attachmentDB.setAttribute5(attachment.getAttribute5());
        attachmentDB.setAttribute6(attachment.getAttribute6());
        attachmentDB.setAttribute7(attachment.getAttribute7());
        attachmentDB.setAttribute8(attachment.getAttribute8());
        attachmentDB.setAttribute9(attachment.getAttribute9());
        attachmentDB.setAttribute10(attachment.getAttribute10());

        attachmentDB.setStatus(attachment.getStatus());

        attachmentDB.setLast_update_by(attachment.getLast_update_by());
        attachmentDB.setLast_update_date(new Date());

        return attachmentRepository.save(attachmentDB);
    }

    @Override
    public Boolean deleteAttachment(Long id) {
        Attachment attachmentDB = getAttachment(id);
        if(null == attachmentDB){
            return false;
        }

        attachmentRepository.deleteById(id);
        return true;
    }
}
