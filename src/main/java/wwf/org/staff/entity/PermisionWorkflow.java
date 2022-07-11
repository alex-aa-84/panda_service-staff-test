package wwf.org.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "per_permission_workflow", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"permissiongeaderId", "step", "stateId"})
})
@Data
public class PermisionWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotNull(message = "permissionHeader_nula")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(referencedColumnName = "id", name = "permissionHeaderId")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private PermissionHeader permissionHeader;

    @NotEmpty(message = "step_vacio")
    @Column(nullable = false)
    private Number step;

    @NotEmpty(message = "workflowState_vacio")
    @Column(nullable = false)
    private Long workflowStateId;

    @NotEmpty(message = "nextworkflowState_vacio")
    @Column(nullable = false)
    private Long nextWorkflowStateId;

    @NotEmpty(message = "rejectionWorkflowState_vacio")
    @Column(nullable = false)
    private Long rejectionWorkflowStateId;

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

    @Temporal(TemporalType.DATE)
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
