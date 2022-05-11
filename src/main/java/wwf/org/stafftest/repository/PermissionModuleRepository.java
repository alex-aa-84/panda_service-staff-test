package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.PermissionModule;

public interface PermissionModuleRepository extends JpaRepository<PermissionModule, Long> {
}
