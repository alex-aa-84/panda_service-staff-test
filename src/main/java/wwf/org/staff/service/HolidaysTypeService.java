package wwf.org.staff.service;

import wwf.org.staff.entity.HolidayType;

import java.util.List;

public interface HolidaysTypeService {

    public List<HolidayType> listAllHolidayType();

    public HolidayType getHolidayType(Long id);

    public HolidayType createHolidayType(HolidayType holidaysType);
    public HolidayType updateHolidayType(HolidayType holidaysType);
    public Boolean deleteHolidayType(Long id);

    public HolidayType findByName(String name);
}
