package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wwf.org.staff.entity.PermissionHeader;
import wwf.org.staff.entity.PermissionModule;

public interface PermissionModuleRepository extends JpaRepository<PermissionModule, Long> {
    public PermissionModule findByPermissionHeaderIdAndModuleId(Long permissionHeaderId, Long moduleId);
    public List<PermissionModule> findByPermissionHeader(PermissionHeader permissionHeader);
}
