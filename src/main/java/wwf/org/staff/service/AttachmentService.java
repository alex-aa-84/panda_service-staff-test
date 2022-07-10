package wwf.org.staff.service;

import wwf.org.staff.entity.Attachment;

import java.util.List;

public interface AttachmentService {
    public List<Attachment> listAllAttachment();
    public Attachment getAttachment(Long id);

    public Attachment createAttachment(Attachment attachment);
    public Attachment updateAttachment(Attachment attachment);
    public Boolean deleteAttachment(Long id);
}
