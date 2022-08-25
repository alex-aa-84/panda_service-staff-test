package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {

    public List<Notes> findByReferenceAndReferenceId(String reference, Long referenceId);

}
