package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    public Profession findByName(String name);
}
