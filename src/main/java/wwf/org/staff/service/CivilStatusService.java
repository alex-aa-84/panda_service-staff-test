package wwf.org.staff.service;

import wwf.org.staff.entity.CivilStatus;

import java.util.List;

public interface CivilStatusService {
    public List<CivilStatus> listAllCivilStatus();
    public CivilStatus getCivilStatus(Long id);

    public CivilStatus createCivilStatus(CivilStatus civilStatus);
    public CivilStatus updateCivilStatus(CivilStatus civilStatus);
    public Boolean deleteCivilStatus(Long id);
    public CivilStatus findByName(String name);
}
