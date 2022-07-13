package wwf.org.staff.service;

import wwf.org.staff.entity.Holidays;

import java.util.Date;
import java.util.List;

public interface HolidaysService {

    public List<Holidays> listAllHolidays();

    public Holidays getHolidays(Long id);

    public Holidays createHolidays(Holidays holidays);
    public Holidays updateHolidays(Holidays holidays);
    public Boolean deleteHolidays(Long id);

    public Holidays findByHolidayTypeIdAndHoliday(Long holidayTypeId, Date holiday);
}
