package wwf.org.stafftest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.stafftest.entity.AddressType;

public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {
    public AddressType findByAddressType(String addressType);
}
