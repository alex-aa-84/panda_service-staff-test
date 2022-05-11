package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> listAllAddress();
    public Address getAddress(Long id);

    public Address createAddress(Address address, Long userId);
    public Address updateAddress(Address address, Long userId);
    public Address deleteAddress(Long id, Long userId);
}
