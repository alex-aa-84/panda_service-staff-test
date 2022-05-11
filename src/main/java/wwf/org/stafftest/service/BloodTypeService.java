package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.BloodType;

import java.util.List;

public interface BloodTypeService {
    public List<BloodType> listAllBloodType();
    public BloodType getBloodType(Long id);

    public BloodType createBloodType(BloodType bloodType, Long userId);
    public BloodType updateBloodType(BloodType bloodType, Long userId);
    public BloodType deleteBloodType(Long id, Long userId);
}
