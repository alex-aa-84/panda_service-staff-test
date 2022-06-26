package wwf.org.stafftest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.stafftest.entity.Address;
import wwf.org.stafftest.repository.AddressRepository;
import wwf.org.stafftest.serviceApi.MD5Util;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> listAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address createAddress(Address address) {
        address.setStatus("CREATED");
        address.setCreation_date(new Date());
        address.setLast_update_date(new Date());

        String md5 = MD5Util.string2MD5(address.toString());
        address.setCtrlMd5(md5);

        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        Address addressDB = getAddress(address.getId());
        if(null == addressDB){
            return null;
        }

        addressDB.setUserId(address.getUserId());
        addressDB.setAddressType(address.getAddressType());
        addressDB.setTerritorialOrgFirst(address.getTerritorialOrgFirst());
        addressDB.setTerritorialOrgTwo(address.getTerritorialOrgTwo());
        addressDB.setTerritorialOrgThree(address.getTerritorialOrgThree());
        addressDB.setTerritorialOrgFour(address.getTerritorialOrgFour());
        addressDB.setTerritorialOrgFive(address.getTerritorialOrgFive());
        addressDB.setNeighborhood(address.getNeighborhood());
        addressDB.setStreet(address.getStreet());
        addressDB.setNumber(address.getNumber());
        addressDB.setBetweenStreet(address.getBetweenStreet());
        addressDB.setPostalCode(address.getPostalCode());
        addressDB.setBuilding(address.getBuilding());
        addressDB.setTower(address.getTower());
        addressDB.setFloor(address.getFloor());
        addressDB.setDepartment(address.getDepartment());
        addressDB.setObservation(address.getObservation());
        addressDB.setLatitude(address.getLatitude());
        addressDB.setLongitude(address.getLongitude());

        addressDB.setAttribute1(address.getAttribute1());
        addressDB.setAttribute2(address.getAttribute2());
        addressDB.setAttribute3(address.getAttribute3());
        addressDB.setAttribute4(address.getAttribute4());
        addressDB.setAttribute5(address.getAttribute5());
        addressDB.setAttribute6(address.getAttribute6());
        addressDB.setAttribute7(address.getAttribute7());
        addressDB.setAttribute8(address.getAttribute8());
        addressDB.setAttribute9(address.getAttribute9());
        addressDB.setAttribute10(address.getAttribute10());

        addressDB.setStatus(address.getStatus());

        addressDB.setLast_update_by(address.getLast_update_by());
        addressDB.setLast_update_date(new Date());

        return addressRepository.save(addressDB);
    }

    @Override
    public Boolean deleteAddress(Long id) {
        Address addressDB = getAddress(id);
        if(null == addressDB){
            return false;
        }

        addressRepository.deleteById(id);
        return true;
    }

    @Override
    public Address findByNeighborhoodAndStreetAndNumber(String neighborhood, String street, String number) {
        return addressRepository.findByNeighborhoodAndStreetAndNumber(neighborhood, street, number);
    }
}
