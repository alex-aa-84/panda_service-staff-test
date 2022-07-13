package wwf.org.staff.service;

import wwf.org.staff.entity.WorkflowWipStatus;

import java.util.List;

public interface WorkflowWipStatusService {
    public List<WorkflowWipStatus> listAllWorkflowWipStatus();

    public WorkflowWipStatus getWorkflowWipStatus(Long id);

    public WorkflowWipStatus createWorkflowWipStatus(WorkflowWipStatus workflowWipStatus);
    public WorkflowWipStatus updateWorkflowWipStatus(WorkflowWipStatus workflowWipStatus);
    public Boolean deleteWorkflowWipStatus(Long id);

    public WorkflowWipStatus findByName(String name);
}
