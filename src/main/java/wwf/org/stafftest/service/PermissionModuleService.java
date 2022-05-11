package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.PermissionModule;

import java.util.List;

public interface PermissionModuleService {
    public List<PermissionModule> listAllPermissionModule();
    public PermissionModule getPermissionModule(Long id);

    public PermissionModule createPermissionModule(PermissionModule permissionModule, Long userId);
    public PermissionModule updatePermissionModule(PermissionModule permissionModule, Long userId);
    public PermissionModule deletePermissionModule(Long id, Long userId);
}
