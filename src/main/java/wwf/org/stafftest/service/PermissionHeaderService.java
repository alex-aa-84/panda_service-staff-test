package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.PermissionHeader;

import java.util.List;

public interface PermissionHeaderService {
    public List<PermissionHeader> listAllPermissionHeader();
    public PermissionHeader getPermissionHeader(Long id);

    public PermissionHeader createPermissionHeader(PermissionHeader permissionHeader, Long userId);
    public PermissionHeader updatePermissionHeader(PermissionHeader permissionHeader, Long userId);
    public PermissionHeader deletePermissionHeader(Long id, Long userId);
}
