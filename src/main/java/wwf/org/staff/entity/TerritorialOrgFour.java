package wwf.org.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(referencedColumnName = "id", name = "territorialOrgConfigId")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TerritorialOrgConfig territorialOrgConfig;

    @NotNull(message = "territorialOrgThree_nula")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(referencedColumnName = "id", name = "territorialOrgThreeId")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TerritorialOrgThree territorialOrgThree;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "territorialOrgFour", cascade = CascadeType.ALL)
    private List<TerritorialOrgFive> territorialOrgFive;

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
