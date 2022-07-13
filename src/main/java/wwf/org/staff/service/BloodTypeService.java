package wwf.org.staff.service;

import wwf.org.staff.entity.BloodType;

import java.util.List;

public interface BloodTypeService {
    public List<BloodType> listAllBloodType();
    public BloodType getBloodType(Long id);

    public BloodType createBloodType(BloodType bloodType);
    public BloodType updateBloodType(BloodType bloodType);
    public Boolean deleteBloodType(Long id);
    public BloodType findByName(String name);
}
