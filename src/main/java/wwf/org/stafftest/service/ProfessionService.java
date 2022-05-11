package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Profession;

import java.util.List;

public interface ProfessionService {
    public List<Profession> listAllProfession();
    public Profession getProfession(Long id);

    public Profession createProfession(Profession profession, Long userId);
    public Profession updateProfession(Profession profession, Long userId);
    public Profession deleteProfession(Long id, Long userId);
}
