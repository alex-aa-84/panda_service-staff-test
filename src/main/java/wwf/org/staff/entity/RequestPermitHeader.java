package wwf.org.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="rp_request_permit_header")
@Data
public class RequestPermitHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private RequestType requestType;

    @Temporal(TemporalType.DATE)
    private Date dateRequest;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private WorkflowSteps workflowSteps;

    @Temporal(TemporalType.DATE)
    private Date lastUpdateWorkflowSteps;

    //Bloqueado cuando el workflowSteps tien los estados cerrados y
    //Habilitado cuando esta en procesos de firma
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private WorkflowWipStatus workflowWipStatus;

    private Boolean flagHours;

    private String observation;

    @OneToMany(mappedBy = "requestPermitHeader", cascade = CascadeType.ALL)
    private List<RequestPermitSignature> requestPermitSignatures;

    @OneToMany(mappedBy = "requestPermitHeader", cascade = CascadeType.ALL)
    private List<RequestPermitPeriods> requestPermitPeriods;

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

    @Column(unique = true, nullable = false)
    @Size(min=32, max = 32)
    private String ctrlMd5;
}
