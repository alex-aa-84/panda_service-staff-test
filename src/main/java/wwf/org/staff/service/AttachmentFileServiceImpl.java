package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.AttachmentFile;
import wwf.org.staff.repository.AttachmentFileRepository;
import wwf.org.staff.serviceApi.MD5Util;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentFileServiceImpl implements AttachmentFileService {
    @Autowired
    private AttachmentFileRepository attachmentFileRepository;

    @Override
    public List<AttachmentFile> listAllAttachmentFile() {
        return attachmentFileRepository.findAll();
    }

    @Override
    public AttachmentFile getAttachmentFile(Long id) {
        return attachmentFileRepository.findById(id).orElse(null);
    }

    @Override
    public AttachmentFile createAttachmentFile(AttachmentFile attachmentFile) {
        attachmentFile.setStatus("CREATED");
        attachmentFile.setCreation_date(new Date());
        attachmentFile.setLast_update_date(new Date());

        String md5 = MD5Util.string2MD5(attachmentFile.toString());
        attachmentFile.setCtrlMd5(md5);

        return attachmentFileRepository.save(attachmentFile);
    }

    @Override
    public AttachmentFile updateAttachmentFile(AttachmentFile attachmentFile) {
        AttachmentFile attachmentFileDB = getAttachmentFile(attachmentFile.getId());
        if(null == attachmentFileDB){
            return null;
        }

        attachmentFileDB.setStaffModule(attachmentFile.getStaffModule());
        attachmentFileDB.setReferenceId(attachmentFile.getReferenceId());
        attachmentFileDB.setName(attachmentFile.getName());
        attachmentFileDB.setLocationFile(attachmentFile.getLocationFile());
        attachmentFileDB.setDescription(attachmentFile.getDescription());

        attachmentFileDB.setAttribute1(attachmentFile.getAttribute1());
        attachmentFileDB.setAttribute2(attachmentFile.getAttribute2());
        attachmentFileDB.setAttribute3(attachmentFile.getAttribute3());
        attachmentFileDB.setAttribute4(attachmentFile.getAttribute4());
        attachmentFileDB.setAttribute5(attachmentFile.getAttribute5());
        attachmentFileDB.setAttribute6(attachmentFile.getAttribute6());
        attachmentFileDB.setAttribute7(attachmentFile.getAttribute7());
        attachmentFileDB.setAttribute8(attachmentFile.getAttribute8());
        attachmentFileDB.setAttribute9(attachmentFile.getAttribute9());
        attachmentFileDB.setAttribute10(attachmentFile.getAttribute10());

        attachmentFileDB.setStatus(attachmentFile.getStatus());

        attachmentFileDB.setLast_update_by(attachmentFile.getLast_update_by());
        attachmentFileDB.setLast_update_date(new Date());

        return attachmentFileRepository.save(attachmentFileDB);
    }

    @Override
    public Boolean deleteAttachmentFile(Long id) {
        AttachmentFile attachmentFileDB = getAttachmentFile(id);
        if(null == attachmentFileDB){
            return false;
        }

        attachmentFileRepository.deleteById(id);
        return true;
    }

}
