package wwf.org.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ts_projects_sheets",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fiscalYear", "monthFiscalYear", "userId", "projectsId"})
})
@Data
public class ProjectsSheets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TimesheetVersion timesheetVersion;

    @Column(nullable = false)
    private Integer fiscalYear;

    @Column(nullable = false)
    private Integer monthFiscalYear;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false, name = "projectsId")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Projects projects;

    @Column(nullable = false)
    private Integer budgetHours;

    @Column(nullable = false)
    private Integer availableHours;

    @Column(nullable = false)
    private Integer usedHours;

    // Este campo se llena si el tipo de timesheet es mensual
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TimesheetCycle timesheetCycle;

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
