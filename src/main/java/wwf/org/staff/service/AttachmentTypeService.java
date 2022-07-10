package wwf.org.staff.service;

import wwf.org.staff.entity.AttachmentType;

import java.util.List;

public interface AttachmentTypeService {
    public List<AttachmentType> listAllAttachmentType();
    public AttachmentType getAttachmentType(Long id);

    public AttachmentType createAttachmentType(AttachmentType attachmentType);
    public AttachmentType updateAttachmentType(AttachmentType attachmentType);
    public Boolean deleteAttachmentType(Long id);
    public AttachmentType findByAttachmentType(String attachmentType);
}
