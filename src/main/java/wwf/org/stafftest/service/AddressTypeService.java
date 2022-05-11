package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.AddressType;

import java.util.List;

public interface AddressTypeService {
    public List<AddressType> listAllAddressType();
    public AddressType getAddressType(Long id);

    public AddressType createAddressType(AddressType addressType, Long userId);
    public AddressType updateAddressType(AddressType addressType, Long userId);
    public AddressType deleteAddressType(Long id, Long userId);
}
