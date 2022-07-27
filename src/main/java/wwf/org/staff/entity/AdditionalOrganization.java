package wwf.org.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ad_additional_organization", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"tenantId", "additionalOrganizationTypeId", "fromTime", "untilTime", "fromMonth", "untilMonth", "value"})
})
@Data
public class AdditionalOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long tenantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "additionalOrganizationTypeId")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private AdditionalOrganizationType additionalOrganizationType;

    // En caso que el tipo sea de formato hora.. se carga en entero
    private Integer fromTime; //Desde hora
    private Integer untilTime; // Hasta hora

    private Integer fromMonth; // Mes desde
    private Integer untilMonth; // Mes Hasta

    private Integer value; // En caso que sea necesario el valor

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
