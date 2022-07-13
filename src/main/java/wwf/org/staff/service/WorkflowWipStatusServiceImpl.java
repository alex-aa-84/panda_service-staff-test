package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.WorkflowWipStatus;
import wwf.org.staff.repository.WorkflowWipStatusRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowWipStatusServiceImpl implements WorkflowWipStatusService {

    @Autowired
    private WorkflowWipStatusRepository repository;

    @Override
    public List<WorkflowWipStatus> listAllWorkflowWipStatus() {
        return repository.findAll();
    }

    @Override
    public WorkflowWipStatus getWorkflowWipStatus(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public WorkflowWipStatus createWorkflowWipStatus(WorkflowWipStatus relationship) {
        relationship.setStatus("CREATED");
        relationship.setCreation_date(new Date());
        relationship.setLast_update_date(new Date());

        return repository.save(relationship);
    }

    @Override
    public WorkflowWipStatus updateWorkflowWipStatus(WorkflowWipStatus relationship) {
        WorkflowWipStatus relationshipDB = getWorkflowWipStatus(relationship.getId());
        if(null == relationshipDB){
            return null;
        }

        relationshipDB.setName(relationship.getName());
        relationshipDB.setDescription(relationship.getDescription());

        relationshipDB.setAttribute1(relationship.getAttribute1());
        relationshipDB.setAttribute2(relationship.getAttribute2());
        relationshipDB.setAttribute3(relationship.getAttribute3());
        relationshipDB.setAttribute4(relationship.getAttribute4());
        relationshipDB.setAttribute5(relationship.getAttribute5());
        relationshipDB.setAttribute6(relationship.getAttribute6());
        relationshipDB.setAttribute7(relationship.getAttribute7());
        relationshipDB.setAttribute8(relationship.getAttribute8());
        relationshipDB.setAttribute9(relationship.getAttribute9());
        relationshipDB.setAttribute10(relationship.getAttribute10());

        relationshipDB.setStatus(relationship.getStatus());

        relationshipDB.setLast_update_by(relationship.getLast_update_by());
        relationshipDB.setLast_update_date(new Date());

        return repository.save(relationshipDB);
    }

    @Override
    public Boolean deleteWorkflowWipStatus(Long id) {
        WorkflowWipStatus relationshipDB = getWorkflowWipStatus(id);
        if(null == relationshipDB){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public WorkflowWipStatus findByName(String name) {
        return repository.findByName(name);
    }

}
