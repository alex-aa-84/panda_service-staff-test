package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.PermissionHeader;
import wwf.org.staff.repository.PermissionHeaderRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionHeaderServiceImpl implements PermissionHeaderService{

    @Autowired
    private PermissionHeaderRepository permissionHeaderRepository;

    @Override
    public List<PermissionHeader> listAllPermissionHeader() {
        return permissionHeaderRepository.findAll();
    }

    @Override
    public PermissionHeader getPermissionHeader(Long id) {
        return permissionHeaderRepository.findById(id).orElse(null);
    }

    @Override
    public PermissionHeader createPermissionHeader(PermissionHeader permissionHeader) {
        permissionHeader.setStatus("CREATED");
        permissionHeader.setCreation_date(new Date());
        permissionHeader.setLast_update_date(new Date());

        return permissionHeaderRepository.save(permissionHeader);
    }

    @Override
    public PermissionHeader updatePermissionHeader(PermissionHeader permissionHeader) {
        PermissionHeader permissionHeaderBD = getPermissionHeader(permissionHeader.getId());
        if(null == permissionHeaderBD){
            return null;
        }

        permissionHeaderBD.setTenantId(permissionHeader.getTenantId());
        permissionHeaderBD.setPermission(permissionHeader.getPermission());
        permissionHeaderBD.setDescription(permissionHeader.getDescription());

        permissionHeaderBD.setAttribute1(permissionHeader.getAttribute1());
        permissionHeaderBD.setAttribute2(permissionHeader.getAttribute2());
        permissionHeaderBD.setAttribute3(permissionHeader.getAttribute3());
        permissionHeaderBD.setAttribute4(permissionHeader.getAttribute4());
        permissionHeaderBD.setAttribute5(permissionHeader.getAttribute5());
        permissionHeaderBD.setAttribute6(permissionHeader.getAttribute6());
        permissionHeaderBD.setAttribute7(permissionHeader.getAttribute7());
        permissionHeaderBD.setAttribute8(permissionHeader.getAttribute8());
        permissionHeaderBD.setAttribute9(permissionHeader.getAttribute9());
        permissionHeaderBD.setAttribute10(permissionHeader.getAttribute10());

        permissionHeaderBD.setStatus(permissionHeader.getStatus());

        permissionHeaderBD.setLast_update_by(permissionHeader.getLast_update_by());
        permissionHeaderBD.setLast_update_date(new Date());


        return permissionHeaderRepository.save(permissionHeaderBD);
    }

    @Override
    public Boolean deletePermissionHeader(Long id) {
        PermissionHeader permissionHeaderBD = getPermissionHeader(id);
        if(null == permissionHeaderBD){
            return false;
        }

        permissionHeaderRepository.deleteById(id);
        return true;
    }

    @Override
    public PermissionHeader findByWorkflowIdAndPermission(Long workflowId, String permission) {
        return permissionHeaderRepository.findByWorkflowIdAndPermission(workflowId, permission);
    }
}
