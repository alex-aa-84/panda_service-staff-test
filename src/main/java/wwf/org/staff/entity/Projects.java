package wwf.org.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ts_projects",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fundingSourceId", "numberProject"})
})
@Data
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotNull(message = "fundingSource_nula")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.ALL})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(referencedColumnName = "id", name = "fundingSourceId")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private FundingSource fundingSource;

    @NotEmpty(message = "numberProject_vacio")
    @Column(nullable = false)
    private String numberProject;

    @NotEmpty(message = "nameProject_vacio")
    @Column(nullable = false)
    private String nameProject;

    @NotEmpty(message = "nameProjectShort_vacio")
    @Column(nullable = false)
    private String nameProjectShort;

    @Column(name = "user_manager")
    private Long userId;

    @Temporal(TemporalType.DATE)
    private Date contractStartDate;

    @Temporal(TemporalType.DATE)
    private Date contractEndDate;

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
