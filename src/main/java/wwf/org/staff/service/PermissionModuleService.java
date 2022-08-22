package wwf.org.staff.service;

import wwf.org.staff.entity.PermissionHeader;
import wwf.org.staff.entity.PermissionModule;

import java.util.List;

public interface PermissionModuleService {
    public List<PermissionModule> listAllPermissionModule();
    public PermissionModule getPermissionModule(Long id);

    public PermissionModule createPermissionModule(PermissionModule permissionModule);
    public PermissionModule updatePermissionModule(PermissionModule permissionModule);
    public Boolean deletePermissionModule(Long id);
    public PermissionModule findByPermissionHeaderIdAndModuleId(Long permissionHeaderId, Long moduleId);
    public List<PermissionModule> findByPermissionHeader(PermissionHeader permissionHeader);
}
