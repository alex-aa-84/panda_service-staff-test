package wwf.org.staff.service;

import wwf.org.staff.entity.AddressType;


import java.util.List;

public interface AddressTypeService {
    public List<AddressType> listAllAddressType();
    public AddressType getAddressType(Long id);

    public AddressType createAddressType(AddressType addressType);
    public AddressType updateAddressType(AddressType addressType);
    public Boolean deleteAddressType(Long id);
    public AddressType findByName(String name);
}
