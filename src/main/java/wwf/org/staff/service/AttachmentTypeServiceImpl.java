package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.AttachmentType;
import wwf.org.staff.repository.AttachmentTypeRepository;

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
    public AttachmentType createAttachmentType(AttachmentType attachmentType) {
        attachmentType.setStatus("CREATED");
        attachmentType.setCreation_date(new Date());
        attachmentType.setLast_update_date(new Date());

        return attachmentTypeRepository.save(attachmentType);
    }

    @Override
    public AttachmentType updateAttachmentType(AttachmentType attachmentType) {
        AttachmentType attachmentTypeBD = getAttachmentType(attachmentType.getId());
        if(null == attachmentTypeBD){
            return null;
        }

        attachmentTypeBD.setAttachmentType(attachmentType.getAttachmentType());

        attachmentTypeBD.setDescription(attachmentType.getDescription());

        attachmentTypeBD.setAttribute1(attachmentType.getAttribute1());
        attachmentTypeBD.setAttribute2(attachmentType.getAttribute2());
        attachmentTypeBD.setAttribute3(attachmentType.getAttribute3());
        attachmentTypeBD.setAttribute4(attachmentType.getAttribute4());
        attachmentTypeBD.setAttribute5(attachmentType.getAttribute5());
        attachmentTypeBD.setAttribute6(attachmentType.getAttribute6());
        attachmentTypeBD.setAttribute7(attachmentType.getAttribute7());
        attachmentTypeBD.setAttribute8(attachmentType.getAttribute8());
        attachmentTypeBD.setAttribute9(attachmentType.getAttribute9());
        attachmentTypeBD.setAttribute10(attachmentType.getAttribute10());

        attachmentTypeBD.setStatus(attachmentType.getStatus());

        attachmentTypeBD.setLast_update_by(attachmentType.getLast_update_by());
        attachmentTypeBD.setLast_update_date(new Date());

        return attachmentTypeRepository.save(attachmentTypeBD);
    }

    @Override
    public Boolean deleteAttachmentType(Long id) {
        AttachmentType attachmentTypeBD = getAttachmentType(id);
        if(null == attachmentTypeBD){
            return false;
        }

        attachmentTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public AttachmentType findByAttachmentType(String attachmentType) {
        return attachmentTypeRepository.findByAttachmentType(attachmentType);
    }
}
