package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.PermissionSubmodule;

import java.util.List;

public interface PermissionSubmoduleService {
    public List<PermissionSubmodule> listAllPermissionSubmodule();
    public PermissionSubmodule getPermissionSubmodule(Long id);

    public PermissionSubmodule createPermissionSubmodule(PermissionSubmodule permissionSubmodule, Long userId);
    public PermissionSubmodule updatePermissionSubmodule(PermissionSubmodule permissionSubmodule, Long userId);
    public PermissionSubmodule deletePermissionSubmodule(Long id, Long userId);
}
