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
    public WorkflowSteps createWorkflowSteps(WorkflowSteps value) {
        value.setStatus("CREATED");
        value.setCreation_date(new Date());
        value.setLast_update_date(new Date());

        return repository.save(value);
    }

    @Override
    public WorkflowSteps updateWorkflowSteps(WorkflowSteps value) {
        WorkflowSteps valueDB = getWorkflowSteps(value.getId());
        if(null == valueDB){
            return null;
        }

        valueDB.setWorkflowId(value.getWorkflowId());
        valueDB.setStep(value.getStep());
        valueDB.setNameStep(value.getNameStep());
        valueDB.setWorkflowStateId(value.getWorkflowStateId());
        valueDB.setWorkflowSignatureId(value.getWorkflowSignatureId());
        valueDB.setNextWorkflowStepId(value.getNextWorkflowStepId());
        valueDB.setRejectionWorkflowStepId(value.getRejectionWorkflowStepId());
        valueDB.setSendEmail(value.getSendEmail());

        valueDB.setDescription(value.getDescription());

        valueDB.setAttribute1(value.getAttribute1());
        valueDB.setAttribute2(value.getAttribute2());
        valueDB.setAttribute3(value.getAttribute3());
        valueDB.setAttribute4(value.getAttribute4());
        valueDB.setAttribute5(value.getAttribute5());
        valueDB.setAttribute6(value.getAttribute6());
        valueDB.setAttribute7(value.getAttribute7());
        valueDB.setAttribute8(value.getAttribute8());
        valueDB.setAttribute9(value.getAttribute9());
        valueDB.setAttribute10(value.getAttribute10());

        valueDB.setStatus(value.getStatus());

        valueDB.setLast_update_by(value.getLast_update_by());
        valueDB.setLast_update_date(new Date());

        return repository.save(valueDB);
    }

    @Override
    public Boolean deleteWorkflowSteps(Long id) {
        WorkflowSteps valueDB = getWorkflowSteps(id);
        if(null == valueDB){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public WorkflowSteps findByWorkflowIdAndStepAndWorkflowStateId(Long workflowId, Integer step, Long workflowStateId) {
        return repository.findByWorkflowIdAndStepAndWorkflowStateId(workflowId, step, workflowStateId);
    }

    @Override
    public WorkflowSteps findByWorkflowIdAndStep(Long workflowid, Integer step) {
        return repository.findByWorkflowIdAndStep(workflowid, step);
    }

}
