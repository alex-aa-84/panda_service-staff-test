package wwf.org.staff.service;

import wwf.org.staff.entity.PermissionHeader;

import java.util.List;

public interface PermissionHeaderService {
    public List<PermissionHeader> listAllPermissionHeader();
    public PermissionHeader getPermissionHeader(Long id);

    public PermissionHeader createPermissionHeader(PermissionHeader permissionHeader);
    public PermissionHeader updatePermissionHeader(PermissionHeader permissionHeader);
    public Boolean deletePermissionHeader(Long id);
    public PermissionHeader findByWorkflowIdAndPermission(Long workflowId, String permission);
}
