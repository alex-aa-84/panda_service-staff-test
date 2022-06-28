package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.PermissionModule;
import wwf.org.stafftest.entity.PermissionSubmodule;

import java.util.List;

public interface PermissionSubmoduleService {
    public List<PermissionSubmodule> listAllPermissionSubmodule();
    public PermissionSubmodule getPermissionSubmodule(Long id);

    public PermissionSubmodule createPermissionSubmodule(PermissionSubmodule permissionSubmodule);
    public PermissionSubmodule updatePermissionSubmodule(PermissionSubmodule permissionSubmodule);
    public Boolean deletePermissionSubmodule(Long id);
    public PermissionSubmodule findByPermissionModuleIdAndSubmoduleAndRoute(PermissionModule permissionModule, String submodule, String route);
}
