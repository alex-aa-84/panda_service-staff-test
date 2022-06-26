package wwf.org.stafftest.service;

import wwf.org.stafftest.entity.CivilStatus;

import java.util.List;

public interface CivilStatusService {
    public List<CivilStatus> listAllCivilStatus();
    public CivilStatus getCivilStatus(Long id);

    public CivilStatus createCivilStatus(CivilStatus civilStatus);
    public CivilStatus updateCivilStatus(CivilStatus civilStatus);
    public Boolean deleteCivilStatus(Long id);
    public CivilStatus findByCivilStatus(String civilStatus);
}
