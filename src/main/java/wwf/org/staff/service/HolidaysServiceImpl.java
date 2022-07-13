package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.CivilStatus;
import wwf.org.staff.entity.Holidays;
import wwf.org.staff.repository.HolidaysRepository;
import wwf.org.staff.serviceApi.MD5Util;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HolidaysServiceImpl implements HolidaysService{
    @Autowired
    private HolidaysRepository holidaysRepository;

    @Override
    public List<Holidays> listAllHolidays() {
        return holidaysRepository.findAll();
    }

    @Override
    public Holidays getHolidays(Long id) {
        return holidaysRepository.findById(id).orElse(null);
    }

    @Override
    public Holidays createHolidays(Holidays holiday) {
        holiday.setStatus("CREATED");
        holiday.setCreation_date(new Date());
        holiday.setLast_update_date(new Date());


        return holidaysRepository.save(holiday);
    }

    @Override
    public Holidays updateHolidays(Holidays holiday) {
        Holidays holidayDB = getHolidays(holiday.getId());
        if(null == holidayDB){
            return null;
        }

        holidayDB.setHolidayType(holiday.getHolidayType());
        holidayDB.setCalendarId(holiday.getCalendarId());
        holidayDB.setHoliday(holiday.getHoliday());

        holidayDB.setDescription(holiday.getDescription());

        holidayDB.setAttribute1(holiday.getAttribute1());
        holidayDB.setAttribute2(holiday.getAttribute2());
        holidayDB.setAttribute3(holiday.getAttribute3());
        holidayDB.setAttribute4(holiday.getAttribute4());
        holidayDB.setAttribute5(holiday.getAttribute5());
        holidayDB.setAttribute6(holiday.getAttribute6());
        holidayDB.setAttribute7(holiday.getAttribute7());
        holidayDB.setAttribute8(holiday.getAttribute8());
        holidayDB.setAttribute9(holiday.getAttribute9());
        holidayDB.setAttribute10(holiday.getAttribute10());

        holidayDB.setStatus(holiday.getStatus());

        holidayDB.setLast_update_by(holiday.getLast_update_by());
        holidayDB.setLast_update_date(new Date());

        return holidaysRepository.save(holidayDB);
    }

    @Override
    public Boolean deleteHolidays(Long id) {
        Holidays holidayDB = getHolidays(id);
        if(null == holidayDB){
            return false;
        }

        holidaysRepository.deleteById(id);
        return true;
    }

    @Override
    public Holidays findByHolidayTypeIdAndHoliday(Long holidayTypeId, Date holiday) {
        return holidaysRepository.findByHolidayTypeIdAndHoliday(holidayTypeId, holiday);
    }


}
