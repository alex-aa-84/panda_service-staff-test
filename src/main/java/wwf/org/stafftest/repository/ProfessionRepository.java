package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    public Profession findByName(String name);
}
