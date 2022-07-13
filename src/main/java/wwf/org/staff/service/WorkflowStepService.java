package wwf.org.staff.service;

import wwf.org.staff.entity.WorkflowSteps;

import java.util.List;

public interface WorkflowStepService {
    public List<WorkflowSteps> listAllWorkflowSteps();

    public WorkflowSteps getWorkflowSteps(Long id);

    public WorkflowSteps createWorkflowSteps(WorkflowSteps workflowSteps);
    public WorkflowSteps updateWorkflowSteps(WorkflowSteps workflowSteps);
    public Boolean deleteWorkflowSteps(Long id);

    public WorkflowSteps findByWorkflowIdAndStepAndWorkflowStateId(Long workflowId, Number step, Long workflowStateId);
}
