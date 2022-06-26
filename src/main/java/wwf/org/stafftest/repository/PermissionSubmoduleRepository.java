package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.PermissionModule;
import wwf.org.stafftest.entity.PermissionSubmodule;

public interface PermissionSubmoduleRepository extends JpaRepository<PermissionSubmodule, Long> {
    public PermissionSubmodule findByPermissionModuleAndSubmoduleAndRoute(PermissionModule permissionModule, String submodule, String route);
}
