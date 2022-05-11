package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.PermissionSubmodule;
import wwf.org.stafftest.repository.PermissionSubmoduleRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionSubmoduleServiceImpl implements PermissionSubmoduleService {

    @Autowired
    private PermissionSubmoduleRepository permissionSubmoduleRepository;


    @Override
    public List<PermissionSubmodule> listAllPermissionSubmodule() {
        return permissionSubmoduleRepository.findAll();
    }

    @Override
    public PermissionSubmodule getPermissionSubmodule(Long id) {
        return permissionSubmoduleRepository.findById(id).orElse(null);
    }

    @Override
    public PermissionSubmodule createPermissionSubmodule(PermissionSubmodule permissionSubmodule, Long userId) {
        permissionSubmodule.setStatus("CREATED");
        permissionSubmodule.setCreate_by(userId);
        permissionSubmodule.setCreation_date(new Date());
        permissionSubmodule.setLast_update_by(userId);
        permissionSubmodule.setLast_update_date(new Date());

        return permissionSubmoduleRepository.save(permissionSubmodule);
    }

    @Override
    public PermissionSubmodule updatePermissionSubmodule(PermissionSubmodule permissionSubmodule, Long userId) {
        PermissionSubmodule permissionSubmoduleDB = getPermissionSubmodule(permissionSubmodule.getId());
        if(null == permissionSubmoduleDB){
            return null;
        }

        permissionSubmodule.setLast_update_by(userId);
        permissionSubmodule.setLast_update_date(new Date());

        return permissionSubmoduleRepository.save(permissionSubmodule);
    }

    @Override
    public PermissionSubmodule deletePermissionSubmodule(Long id, Long userId) {
        PermissionSubmodule permissionSubmoduleDB = getPermissionSubmodule(id);
        if(null == permissionSubmoduleDB){
            return null;
        }

        permissionSubmoduleDB.setStatus("DELETED");
        permissionSubmoduleDB.setLast_update_by(userId);
        permissionSubmoduleDB.setLast_update_date(new Date());

        return permissionSubmoduleRepository.save(permissionSubmoduleDB);
    }
}
