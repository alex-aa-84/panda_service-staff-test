package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.HolidayType;
import wwf.org.staff.repository.HolidaysTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HolidaysTypeServiceImpl implements HolidaysTypeService{

    @Autowired
    private HolidaysTypeRepository holidayTypeRepository;

    @Override
    public List<HolidayType> listAllHolidayType() {
        return holidayTypeRepository.findAll();
    }

    @Override
    public HolidayType getHolidayType(Long id) {
        return holidayTypeRepository.findById(id).orElse(null);
    }

    @Override
    public HolidayType createHolidayType(HolidayType holidayType) {
        holidayType.setStatus("CREATED");
        holidayType.setCreation_date(new Date());
        holidayType.setLast_update_date(new Date());

        return holidayTypeRepository.save(holidayType);
    }

    @Override
    public HolidayType updateHolidayType(HolidayType holidayType) {
        HolidayType holidayTypeDB = getHolidayType(holidayType.getId());
        if(null == holidayTypeDB){
            return null;
        }

        holidayTypeDB.setName(holidayType.getName());

        holidayTypeDB.setDescription(holidayType.getDescription());

        holidayTypeDB.setAttribute1(holidayType.getAttribute1());
        holidayTypeDB.setAttribute2(holidayType.getAttribute2());
        holidayTypeDB.setAttribute3(holidayType.getAttribute3());
        holidayTypeDB.setAttribute4(holidayType.getAttribute4());
        holidayTypeDB.setAttribute5(holidayType.getAttribute5());
        holidayTypeDB.setAttribute6(holidayType.getAttribute6());
        holidayTypeDB.setAttribute7(holidayType.getAttribute7());
        holidayTypeDB.setAttribute8(holidayType.getAttribute8());
        holidayTypeDB.setAttribute9(holidayType.getAttribute9());
        holidayTypeDB.setAttribute10(holidayType.getAttribute10());

        holidayTypeDB.setStatus(holidayType.getStatus());

        holidayTypeDB.setLast_update_by(holidayType.getLast_update_by());
        holidayTypeDB.setLast_update_date(new Date());

        return holidayTypeRepository.save(holidayTypeDB);
    }

    @Override
    public Boolean deleteHolidayType(Long id) {
        HolidayType holidayTypeDB = getHolidayType(id);
        if(null == holidayTypeDB){
            return false;
        }

        holidayTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public HolidayType findByName(String name) {
        return holidayTypeRepository.findByName(name);
    }
}
