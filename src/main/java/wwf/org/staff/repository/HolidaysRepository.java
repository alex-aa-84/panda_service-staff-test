package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Holidays;

import java.util.Date;

public interface HolidaysRepository extends JpaRepository<Holidays, Long> {
    public Holidays findByHolidayTypeIdAndHoliday(Long holidayTypeId, Date holiday);
}
