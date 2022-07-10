package wwf.org.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="to_territorial_org_four", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"territorialOrgThreeId", "name"})
})
@Data
public class TerritorialOrgFour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotNull(message = "territorialOrgThree_nula")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(referencedColumnName = "id", name = "territorialOrgThreeId")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TerritorialOrgThree territorialOrgThree;

    @NotEmpty(message = "name_territorio_generico_vacio")
    @Column(nullable = false)
    private String name;

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
