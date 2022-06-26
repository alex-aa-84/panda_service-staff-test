package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.Profession;

import java.util.List;

public interface ProfessionService {
    public List<Profession> listAllProfession();
    public Profession getProfession(Long id);

    public Profession createProfession(Profession profession);
    public Profession updateProfession(Profession profession);
    public Boolean deleteProfession(Long id);

    public Profession findByName(String name);

}
