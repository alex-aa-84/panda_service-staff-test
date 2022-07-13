package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.WorkflowWipStatus;

public interface WorkflowWipStatusRepository extends JpaRepository<WorkflowWipStatus, Long> {
    public WorkflowWipStatus findByName(String name);
}
