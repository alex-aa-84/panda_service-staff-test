package wwf.org.staff.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wf_workflow_steps", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"workflowId", "step", "workflowStateId"})
})
@Data
public class WorkflowSteps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    // Se definira si es para timesheet, permisos, rodados, etc...
    @Column(nullable = false)
    private Long workflowId;

    @Column(nullable = false)
    private Integer step;

    @Column(nullable = false)
    private String nameStep;

    @Column(nullable = false)
    private Long workflowStateId;

    // Responsable de Este Workflow Firma
    @Column(nullable = false)
    private Long workflowSignatureId;

    @Column(nullable = false)
    private Long nextWorkflowStepId;

    @Column(nullable = false)
    private Long rejectionWorkflowStepId;

    @Column(nullable = false)
    private Long sendEmail;

    private String description;
    private Integer attribute1;
    private Integer attribute2;
    private Integer attribute3;
    private Integer attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;

    @Temporal(TemporalType.TIMESTAMP)
    private Date attribute9 ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date attribute10;

    private String status;
    private Long create_by;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date;

    private Long last_update_by;

    @Temporal(TemporalType.TIMESTAMP)
    private Date last_update_date;
}
