package wwf.org.staff.service;

import wwf.org.staff.entity.StaffModule;

import java.util.List;

public interface StaffModuleService {
    public List<StaffModule> listAllStaffModule();
    public StaffModule getStaffModule(Long id);

    public StaffModule createStaffModule(StaffModule staffModule);
    public StaffModule updateStaffModule(StaffModule staffModule);
    public Boolean deleteStaffModule(Long id);

    public StaffModule findByModuleIdAndSubmodule(Long moduleId, String submodule);
}
