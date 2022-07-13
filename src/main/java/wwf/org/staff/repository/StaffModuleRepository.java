package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Profession;
import wwf.org.staff.entity.StaffModule;

public interface StaffModuleRepository extends JpaRepository<StaffModule, Long> {
    public StaffModule findByModuleIdAndSubmodule(Long moduleId, String submodule);
}
