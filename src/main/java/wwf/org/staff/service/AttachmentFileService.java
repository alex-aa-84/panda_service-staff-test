package wwf.org.staff.service;


import wwf.org.staff.entity.AttachmentFile;

import java.util.List;

public interface AttachmentFileService {
    public List<AttachmentFile> listAllAttachmentFile();
    public AttachmentFile getAttachmentFile(Long id);

    public AttachmentFile createAttachmentFile(AttachmentFile attachmentFile);
    public AttachmentFile updateAttachmentFile(AttachmentFile attachmentFile);
    public Boolean deleteAttachmentFile(Long id);

    public List<AttachmentFile> findByReferenceAndReferenceId(String reference, Long referenceId);

}
