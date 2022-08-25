package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.Notes;
import wwf.org.staff.repository.NotesRepository;
import wwf.org.staff.serviceApi.MD5Util;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesRepository notesRepository;

    @Override
    public List<Notes> listAllNotes() {
        return notesRepository.findAll();
    }

    @Override
    public Notes getNotes(Long id) {
        return notesRepository.findById(id).orElse(null);
    }

    @Override
    public Notes createNotes(Notes notes) {
        notes.setReference(notes.getReference().toLowerCase().trim());
        notes.setStatus("CREATED");
        notes.setCreation_date(new Date());
        notes.setLast_update_date(new Date());

        String md5 = MD5Util.string2MD5(notes.toString());
        notes.setCtrlMd5(md5);

        return notesRepository.save(notes);
    }

    @Override
    public Notes updateNotes(Notes notes) {
        Notes notesDB = getNotes(notes.getId());
        if(null == notesDB){
            return null;
        }

        notesDB.setReference(notes.getReference().toLowerCase().trim());
        notesDB.setReferenceId(notes.getReferenceId());
        notesDB.setNote(notes.getNote());

        notesDB.setAttribute1(notes.getAttribute1());
        notesDB.setAttribute2(notes.getAttribute2());
        notesDB.setAttribute3(notes.getAttribute3());
        notesDB.setAttribute4(notes.getAttribute4());
        notesDB.setAttribute5(notes.getAttribute5());
        notesDB.setAttribute6(notes.getAttribute6());
        notesDB.setAttribute7(notes.getAttribute7());
        notesDB.setAttribute8(notes.getAttribute8());
        notesDB.setAttribute9(notes.getAttribute9());
        notesDB.setAttribute10(notes.getAttribute10());

        notesDB.setStatus(notes.getStatus());

        notesDB.setLast_update_by(notes.getLast_update_by());
        notesDB.setLast_update_date(new Date());

        return notesRepository.save(notesDB);
    }

    @Override
    public Boolean deleteNotes(Long id) {
        Notes notesDB = getNotes(id);
        if(null == notesDB){
            return false;
        }

        notesRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Notes> findByReferenceAndReferenceId(String reference, Long referenceId) {
        // TODO Auto-generated method stub
        reference = reference.toLowerCase().trim();
        return notesRepository.findByReferenceAndReferenceId(reference, referenceId);
    }
}
