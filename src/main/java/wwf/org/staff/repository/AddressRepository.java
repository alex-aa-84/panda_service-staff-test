package wwf.org.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    public List<Address> findByUserId(Long id);
}
