package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.AddressType;

public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {
    public AddressType findByName(String name);
}
