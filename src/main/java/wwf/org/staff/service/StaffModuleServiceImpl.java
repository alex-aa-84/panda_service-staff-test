package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.StaffModule;
import wwf.org.staff.repository.StaffModuleRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffModuleServiceImpl implements StaffModuleService{

    @Autowired
    private StaffModuleRepository staffModuleRepository;

    @Override
    public List<StaffModule> listAllStaffModule() {
        return staffModuleRepository.findAll();
    }

    @Override
    public StaffModule getStaffModule(Long id) {
        return staffModuleRepository.findById(id).orElse(null);
    }

    @Override
    public StaffModule createStaffModule(StaffModule staffModule) {
        staffModule.setStatus("CREATED");
        staffModule.setCreation_date(new Date());
        staffModule.setLast_update_date(new Date());

        return staffModuleRepository.save(staffModule);
    }

    @Override
    public StaffModule updateStaffModule(StaffModule staffModule) {
        StaffModule staffModuleDB = getStaffModule(staffModule.getId());
        if(null == staffModuleDB){
            return null;
        }

        staffModuleDB.setModuleId(staffModule.getModuleId());
        staffModuleDB.setSubmodule(staffModule.getSubmodule());
        staffModuleDB.setDescription(staffModule.getDescription());
        staffModuleDB.setImageConfig(staffModule.getImageConfig());
        staffModuleDB.setRouterLink(staffModule.getRouterLink());
        staffModuleDB.setServiceUrl(staffModule.getServiceUrl());

        staffModuleDB.setAttribute1(staffModule.getAttribute1());
        staffModuleDB.setAttribute2(staffModule.getAttribute2());
        staffModuleDB.setAttribute3(staffModule.getAttribute3());
        staffModuleDB.setAttribute4(staffModule.getAttribute4());
        staffModuleDB.setAttribute5(staffModule.getAttribute5());
        staffModuleDB.setAttribute6(staffModule.getAttribute6());
        staffModuleDB.setAttribute7(staffModule.getAttribute7());
        staffModuleDB.setAttribute8(staffModule.getAttribute8());
        staffModuleDB.setAttribute9(staffModule.getAttribute9());
        staffModuleDB.setAttribute10(staffModule.getAttribute10());

        staffModuleDB.setStatus(staffModule.getStatus());

        staffModuleDB.setLast_update_by(staffModule.getLast_update_by());
        staffModuleDB.setLast_update_date(new Date());

        return staffModuleRepository.save(staffModuleDB);
    }

    @Override
    public Boolean deleteStaffModule(Long id) {
        StaffModule staffModuleDB = getStaffModule(id);
        if(null == staffModuleDB){
            return false;
        }

        staffModuleRepository.deleteById(id);
        return true;
    }

    @Override
    public StaffModule findByModuleIdAndSubmodule(Long moduleId, String submodule) {
        return staffModuleRepository.findByModuleIdAndSubmodule(moduleId, submodule);
    }

}
