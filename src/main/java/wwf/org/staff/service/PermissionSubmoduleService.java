package wwf.org.staff.service;

import wwf.org.staff.entity.PermissionModule;
import wwf.org.staff.entity.PermissionSubmodule;

import java.util.List;

public interface PermissionSubmoduleService {
    public List<PermissionSubmodule> listAllPermissionSubmodule();
    public PermissionSubmodule getPermissionSubmodule(Long id);

    public PermissionSubmodule createPermissionSubmodule(PermissionSubmodule permissionSubmodule);
    public PermissionSubmodule updatePermissionSubmodule(PermissionSubmodule permissionSubmodule);
    public Boolean deletePermissionSubmodule(Long id);
    public PermissionSubmodule findByPermissionModuleIdAndSubmodulesId(Long permissionModuleId, Long submodulesId);
    public List<PermissionSubmodule> findByPermissionModule(PermissionModule permissionModule);
}
