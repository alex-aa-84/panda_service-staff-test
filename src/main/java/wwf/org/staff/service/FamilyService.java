package wwf.org.staff.service;

import wwf.org.staff.entity.Family;

import java.util.List;

public interface FamilyService {
    public List<Family> listAllFamily();
    public Family getFamily(Long id);

    public Family createFamily(Family family);
    public Family updateFamily(Family family);
    public Boolean deleteFamily(Long id);
    public List<Family> findByUserId(Long id);
}
