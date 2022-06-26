package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> listAllAddress();
    public Address getAddress(Long id);

    public Address createAddress(Address address);
    public Address updateAddress(Address address);
    public Boolean deleteAddress(Long id);

    public Address findByNeighborhoodAndStreetAndNumber(String neighborhood, String street, String number);
}
