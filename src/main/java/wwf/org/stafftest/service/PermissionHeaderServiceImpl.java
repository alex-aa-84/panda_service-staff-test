package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.PermissionHeader;
import wwf.org.stafftest.repository.PermissionHeaderRepository;

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
    public PermissionHeader createPermissionHeader(PermissionHeader permissionHeader, Long userId) {
        permissionHeader.setStatus("CREATED");
        permissionHeader.setCreate_by(userId);
        permissionHeader.setCreation_date(new Date());
        permissionHeader.setLast_update_by(userId);
        permissionHeader.setLast_update_date(new Date());

        return permissionHeaderRepository.save(permissionHeader);
    }

    @Override
    public PermissionHeader updatePermissionHeader(PermissionHeader permissionHeader, Long userId) {
        PermissionHeader permissionHeaderBD = getPermissionHeader(permissionHeader.getId());
        if(null == permissionHeaderBD){
            return null;
        }

        permissionHeader.setLast_update_by(userId);
        permissionHeader.setLast_update_date(new Date());

        return permissionHeaderRepository.save(permissionHeader);
    }

    @Override
    public PermissionHeader deletePermissionHeader(Long id, Long userId) {
        PermissionHeader permissionHeaderBD = getPermissionHeader(id);
        if(null == permissionHeaderBD){
            return null;
        }

        permissionHeaderBD.setStatus("DELETED");
        permissionHeaderBD.setLast_update_by(userId);
        permissionHeaderBD.setLast_update_date(new Date());

        return permissionHeaderRepository.save(permissionHeaderBD);
    }
}
