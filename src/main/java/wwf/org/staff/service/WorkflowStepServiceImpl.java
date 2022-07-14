package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.WorkflowSteps;
import wwf.org.staff.repository.WorkflowStepRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowStepServiceImpl implements WorkflowStepService {

    @Autowired
    private WorkflowStepRepository repository;

    @Override
    public List<WorkflowSteps> listAllWorkflowSteps() {
        return repository.findAll();
    }

    @Override
    public WorkflowSteps getWorkflowSteps(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public WorkflowSteps createWorkflowSteps(WorkflowSteps relationship) {
        relationship.setStatus("CREATED");
        relationship.setCreation_date(new Date());
        relationship.setLast_update_date(new Date());

        return repository.save(relationship);
    }

    @Override
    public WorkflowSteps updateWorkflowSteps(WorkflowSteps relationship) {
        WorkflowSteps relationshipDB = getWorkflowSteps(relationship.getId());
        if(null == relationshipDB){
            return null;
        }

        relationshipDB.setWorkflowId(relationship.getWorkflowId());
        relationshipDB.setStep(relationship.getStep());
        relationshipDB.setNameStep(relationship.getNameStep());
        relationshipDB.setWorkflowStateId(relationship.getWorkflowStateId());
        relationshipDB.setNextWorkflowStateId(relationship.getNextWorkflowStateId());
        relationshipDB.setRejectionWorkflowStateId(relationship.getRejectionWorkflowStateId());
        relationshipDB.setSendEmail(relationship.getSendEmail());

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
    public Boolean deleteWorkflowSteps(Long id) {
        WorkflowSteps relationshipDB = getWorkflowSteps(id);
        if(null == relationshipDB){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public WorkflowSteps findByWorkflowIdAndStepAndWorkflowStateId(Long workflowId, Integer step, Long workflowStateId) {
        return repository.findByWorkflowIdAndStepAndWorkflowStateId(workflowId, step, workflowStateId);
    }

}
