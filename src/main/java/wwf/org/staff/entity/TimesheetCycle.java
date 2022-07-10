package wwf.org.staff.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "ts_timesheet_wip_status",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fiscalYear", "monthFiscalYear"})
})
@Data
public class TimesheetCycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotEmpty(message = "fiscalYear_vacio")
    @Column(nullable = false)
    private Integer fiscalYear;

    @NotEmpty(message = "fiscalYear_vacio")
    @Column(nullable = false)
    private Integer monthFiscalYear;

    //0 ó 1, 1 es el mes en curso ó seleccionado
    @NotEmpty(message = "onGoing_vacio")
    @Column(nullable = false)
    private Number onGoing;

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
