package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.AttachmentType;

import java.util.List;

public interface AttachmentTypeService {
    public List<AttachmentType> listAllAttachmentType();
    public AttachmentType getAttachmentType(Long id);

    public AttachmentType createAttachmentType(AttachmentType attachmentType, Long userId);
    public AttachmentType updateAttachmentType(AttachmentType attachmentType, Long userId);
    public AttachmentType deleteAttachmentType(Long id, Long userId);
}
