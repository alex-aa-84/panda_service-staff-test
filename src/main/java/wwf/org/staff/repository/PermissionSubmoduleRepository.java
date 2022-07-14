package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.PermissionSubmodule;

public interface PermissionSubmoduleRepository extends JpaRepository<PermissionSubmodule, Long> {
    public PermissionSubmodule findByPermissionModuleIdAndStaffModuleId(Long permissionModuleId, Long staffModuleId);
}
