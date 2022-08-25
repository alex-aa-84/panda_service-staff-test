package wwf.org.staff.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="rp_request_permit_periods")
@Data
public class RequestPermitPeriods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;

    @Column(precision = 10, scale = 2)
    private Double hours;

    /// Aqui acumulara el total de todos
    @Column(precision = 10, scale = 2)
    private Double total;

    //l es linea y r es rango de fecha
    private String type;

    // 0 ó 1
    private Boolean midday;

    @OneToMany(targetEntity = RequestPermitDays.class, cascade = CascadeType.ALL)
    @JoinColumn(name="request_permit_periods_id", referencedColumnName = "id")
    private List<RequestPermitDays> requestPermitDays;


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

    @Column(unique = true, nullable = false)
    @Size(min=32, max = 32)
    private String ctrlMd5;
}
