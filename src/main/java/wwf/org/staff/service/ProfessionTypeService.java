package wwf.org.staff.service;

import wwf.org.staff.entity.ProfessionType;

import java.util.List;

public interface ProfessionTypeService {
    public List<ProfessionType> listAllProfessionType();
    public ProfessionType getProfessionType(Long id);

    public ProfessionType createProfessionType(ProfessionType professionType);
    public ProfessionType updateProfessionType(ProfessionType professionType);
    public Boolean deleteProfessionType(Long id);
    public ProfessionType findByName(String name);
}
