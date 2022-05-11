package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.ProfessionType;

import java.util.List;

public interface ProfessionTypeService {
    public List<ProfessionType> listAllProfessionType();
    public ProfessionType getProfessionType(Long id);

    public ProfessionType createProfessionType(ProfessionType professionType, Long userId);
    public ProfessionType updateProfessionType(ProfessionType professionType, Long userId);
    public ProfessionType deleteProfessionType(Long id, Long userId);
}
