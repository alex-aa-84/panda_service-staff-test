package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.TimesheetType;
import wwf.org.staff.entity.WorkflowSteps;

public interface WorkflowStepRepository extends JpaRepository<WorkflowSteps, Long> {
    public WorkflowSteps findByWorkflowIdAndStepAndWorkflowStateId(Long workflowId, Number step, Long workflowStateId);
}
