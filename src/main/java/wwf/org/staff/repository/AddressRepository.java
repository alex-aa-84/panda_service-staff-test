package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

    public Address findByNeighborhoodAndStreetAndNumber(String neighborhood, String street, String number);
}
