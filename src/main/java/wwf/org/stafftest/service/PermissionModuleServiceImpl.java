package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.entity.PermissionModule;
import wwf.org.stafftest.repository.PermissionModuleRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionModuleServiceImpl implements PermissionModuleService {

    @Autowired
    private PermissionModuleRepository permissionModuleRepository;

    @Override
    public List<PermissionModule> listAllPermissionModule() {
        return permissionModuleRepository.findAll();
    }

    @Override
    public PermissionModule getPermissionModule(Long id) {
        return permissionModuleRepository.findById(id).orElse(null);
    }

    @Override
    public PermissionModule createPermissionModule(PermissionModule permissionModule, Long userId) {
        permissionModule.setStatus("CREATED");
        permissionModule.setCreate_by(userId);
        permissionModule.setCreation_date(new Date());
        permissionModule.setLast_update_by(userId);
        permissionModule.setLast_update_date(new Date());

        return permissionModuleRepository.save(permissionModule);
    }

    @Override
    public PermissionModule updatePermissionModule(PermissionModule permissionModule, Long userId) {
        PermissionModule permissionModuleBD = getPermissionModule(permissionModule.getId());
        if(null == permissionModuleBD){
            return null;
        }

        permissionModule.setLast_update_by(userId);
        permissionModule.setLast_update_date(new Date());

        return permissionModuleRepository.save(permissionModule);
    }

    @Override
    public PermissionModule deletePermissionModule(Long id, Long userId) {
        PermissionModule permissionModuleBD = getPermissionModule(id);
        if(null == permissionModuleBD){
            return null;
        }

        permissionModuleBD.setStatus("DELETED");
        permissionModuleBD.setLast_update_by(userId);
        permissionModuleBD.setLast_update_date(new Date());

        return permissionModuleRepository.save(permissionModuleBD);
    }
}
