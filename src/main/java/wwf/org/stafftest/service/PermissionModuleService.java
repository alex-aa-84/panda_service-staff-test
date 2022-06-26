package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.PermissionHeader;
import wwf.org.stafftest.entity.PermissionModule;

import java.util.List;

public interface PermissionModuleService {
    public List<PermissionModule> listAllPermissionModule();
    public PermissionModule getPermissionModule(Long id);

    public PermissionModule createPermissionModule(PermissionModule permissionModule);
    public PermissionModule updatePermissionModule(PermissionModule permissionModule);
    public Boolean deletePermissionModule(Long id);

    public PermissionModule findByPermissionHeaderAndModuleId(PermissionHeader permissionHeader, Long moduleId);
}
