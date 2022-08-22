package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wwf.org.staff.entity.PermissionModule;
import wwf.org.staff.entity.PermissionSubmodule;

public interface PermissionSubmoduleRepository extends JpaRepository<PermissionSubmodule, Long> {
    public PermissionSubmodule findByPermissionModuleIdAndSubmodulesId(Long permissionModuleId, Long submodulesId);
    public List<PermissionSubmodule> findByPermissionModule(PermissionModule permissionModule);
}
