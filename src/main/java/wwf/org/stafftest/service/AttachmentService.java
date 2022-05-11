package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Attachment;

import java.util.List;

public interface AttachmentService {
    public List<Attachment> listAllAttachment();
    public Attachment getAttachment(Long id);

    public Attachment createAttachment(Attachment attachment, Long userId);
    public Attachment updateAttachment(Attachment attachment, Long userId);
    public Attachment deleteAttachment(Long id, Long userId);
}
