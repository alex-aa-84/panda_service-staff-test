package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.PermissionHeader;
import wwf.org.staff.entity.PermissionModule;
import wwf.org.staff.repository.PermissionModuleRepository;

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
    public PermissionModule createPermissionModule(PermissionModule permissionModule) {
        permissionModule.setStatus("CREATED");
        permissionModule.setCreation_date(new Date());
        permissionModule.setLast_update_date(new Date());

        return permissionModuleRepository.save(permissionModule);
    }

    @Override
    public PermissionModule updatePermissionModule(PermissionModule permissionModule) {
        PermissionModule permissionModuleBD = getPermissionModule(permissionModule.getId());
        if(null == permissionModuleBD){
            return null;
        }

        permissionModuleBD.setPermissionHeader(permissionModule.getPermissionHeader());
        permissionModuleBD.setModuleId(permissionModule.getModuleId());
        permissionModuleBD.setDescription(permissionModule.getDescription());

        permissionModuleBD.setAttribute1(permissionModule.getAttribute1());
        permissionModuleBD.setAttribute2(permissionModule.getAttribute2());
        permissionModuleBD.setAttribute3(permissionModule.getAttribute3());
        permissionModuleBD.setAttribute4(permissionModule.getAttribute4());
        permissionModuleBD.setAttribute5(permissionModule.getAttribute5());
        permissionModuleBD.setAttribute6(permissionModule.getAttribute6());
        permissionModuleBD.setAttribute7(permissionModule.getAttribute7());
        permissionModuleBD.setAttribute8(permissionModule.getAttribute8());
        permissionModuleBD.setAttribute9(permissionModule.getAttribute9());
        permissionModuleBD.setAttribute10(permissionModule.getAttribute10());

        permissionModuleBD.setStatus(permissionModule.getStatus());

        permissionModuleBD.setLast_update_by(permissionModule.getLast_update_by());
        permissionModuleBD.setLast_update_date(new Date());

        return permissionModuleRepository.save(permissionModuleBD);
    }

    @Override
    public Boolean deletePermissionModule(Long id) {
        PermissionModule permissionModuleBD = getPermissionModule(id);
        if(null == permissionModuleBD){
            return false;
        }

        permissionModuleRepository.deleteById(id);
        return true;
    }

    @Override
    public PermissionModule findByPermissionHeaderIdAndModuleId(PermissionHeader permissionHeader, Long moduleId) {
        return permissionModuleRepository.findByPermissionHeaderIdAndModuleId(permissionHeader.getId(), moduleId);
    }
}
