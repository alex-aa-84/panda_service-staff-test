package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.PermissionModule;
import wwf.org.staff.entity.PermissionSubmodule;
import wwf.org.staff.repository.PermissionSubmoduleRepository;

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
    public PermissionSubmodule createPermissionSubmodule(PermissionSubmodule permissionSubmodule) {
        permissionSubmodule.setStatus("CREATED");
        permissionSubmodule.setCreation_date(new Date());
        permissionSubmodule.setLast_update_date(new Date());

        return permissionSubmoduleRepository.save(permissionSubmodule);
    }

    @Override
    public PermissionSubmodule updatePermissionSubmodule(PermissionSubmodule permissionSubmodule) {
        PermissionSubmodule permissionSubmoduleDB = getPermissionSubmodule(permissionSubmodule.getId());
        if(null == permissionSubmoduleDB){
            return null;
        }

        permissionSubmoduleDB.setPermissionModule(permissionSubmodule.getPermissionModule());
        permissionSubmoduleDB.setStaffModule(permissionSubmodule.getStaffModule());

        permissionSubmoduleDB.setDescription(permissionSubmodule.getDescription());

        permissionSubmoduleDB.setAttribute1(permissionSubmodule.getAttribute1());
        permissionSubmoduleDB.setAttribute2(permissionSubmodule.getAttribute2());
        permissionSubmoduleDB.setAttribute3(permissionSubmodule.getAttribute3());
        permissionSubmoduleDB.setAttribute4(permissionSubmodule.getAttribute4());
        permissionSubmoduleDB.setAttribute5(permissionSubmodule.getAttribute5());
        permissionSubmoduleDB.setAttribute6(permissionSubmodule.getAttribute6());
        permissionSubmoduleDB.setAttribute7(permissionSubmodule.getAttribute7());
        permissionSubmoduleDB.setAttribute8(permissionSubmodule.getAttribute8());
        permissionSubmoduleDB.setAttribute9(permissionSubmodule.getAttribute9());
        permissionSubmoduleDB.setAttribute10(permissionSubmodule.getAttribute10());

        permissionSubmoduleDB.setStatus(permissionSubmodule.getStatus());

        permissionSubmoduleDB.setLast_update_by(permissionSubmodule.getLast_update_by());
        permissionSubmoduleDB.setLast_update_date(new Date());

        return permissionSubmoduleRepository.save(permissionSubmoduleDB);
    }

    @Override
    public Boolean deletePermissionSubmodule(Long id) {
        PermissionSubmodule permissionSubmoduleDB = getPermissionSubmodule(id);
        if(null == permissionSubmoduleDB){
            return true;
        }

        permissionSubmoduleRepository.deleteById(id);
        return false;
    }

    @Override
    public PermissionSubmodule findByPermissionModuleIdAndStaffModuleId(Long permissionModuleId, Long staffModuleId) {
        return permissionSubmoduleRepository.findByPermissionModuleIdAndStaffModuleId(permissionModuleId, staffModuleId);
    }
}
