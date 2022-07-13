package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {

}
