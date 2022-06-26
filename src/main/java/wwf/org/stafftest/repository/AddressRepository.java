package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

    public Address findByNeighborhoodAndStreetAndNumber(String neighborhood, String street, String number);
}
