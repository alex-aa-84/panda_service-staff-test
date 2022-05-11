package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Family;

import java.util.List;

public interface FamilyService {
    public List<Family> listAllFamily();
    public Family getFamily(Long id);

    public Family createFamily(Family family, Long userId);
    public Family updateFamily(Family family, Long userId);
    public Family deleteFamily(Long id, Long userId);
}
