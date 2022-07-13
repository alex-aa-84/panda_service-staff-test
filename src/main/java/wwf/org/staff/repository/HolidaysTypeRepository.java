package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.DocumentType;
import wwf.org.staff.entity.HolidayType;

public interface HolidaysTypeRepository extends JpaRepository<HolidayType, Long> {
    public HolidayType findByName(String name);
}
