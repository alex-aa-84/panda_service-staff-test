package wwf.org.staff.service;

import wwf.org.staff.entity.Notes;

import java.util.List;

public interface NotesService {
    public List<Notes> listAllNotes();
    public Notes getNotes(Long id);

    public Notes createNotes(Notes notes);
    public Notes updateNotes(Notes notes);
    public Boolean deleteNotes(Long id);

    public List<Notes> findByReferenceAndReferenceId(String reference, Long referenceId);
}
