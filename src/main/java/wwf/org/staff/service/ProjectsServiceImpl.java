package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.Projects;
import wwf.org.staff.repository.ProjectsRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsService{

    @Autowired
    private ProjectsRepository repository;


    @Override
    public List<Projects> listAllProjects() {
        return repository.findAll();
    }

    @Override
    public Projects getProjects(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Projects createProjects(Projects value) {
        value.setStatus("CREATED");
        value.setCreation_date(new Date());
        value.setLast_update_date(new Date());

        return repository.save(value);
    }

    @Override
    public Projects updateProjects(Projects value) {
        Projects bd = getProjects(value.getId());
        if(null == bd){
            return null;
        }

        bd.setFundingSource(value.getFundingSource());
        bd.setNumberProject(value.getNumberProject());
        bd.setNameProject(value.getNameProject());
        bd.setNameProjectShort(value.getNameProjectShort());

        bd.setUserId(value.getUserId());
        bd.setContractStartDate(bd.getContractStartDate());
        bd.setContractEndDate(value.getContractEndDate());

        bd.setDescription(value.getDescription());
        bd.setAttribute1(value.getAttribute1());
        bd.setAttribute2(value.getAttribute2());
        bd.setAttribute3(value.getAttribute3());
        bd.setAttribute4(value.getAttribute4());
        bd.setAttribute5(value.getAttribute5());
        bd.setAttribute6(value.getAttribute6());
        bd.setAttribute7(value.getAttribute7());
        bd.setAttribute8(value.getAttribute8());
        bd.setAttribute9(value.getAttribute9());
        bd.setAttribute10(value.getAttribute10());

        bd.setStatus(value.getStatus());

        bd.setLast_update_by(value.getLast_update_by());
        bd.setLast_update_date(new Date());

        return repository.save(bd);
    }

    @Override
    public Boolean deleteProjects(Long id) {
        Projects bd = getProjects(id);
        if(null == bd){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public Projects findByNumberProject(String val) {
        return repository.findByNumberProject(val);
    }
}
