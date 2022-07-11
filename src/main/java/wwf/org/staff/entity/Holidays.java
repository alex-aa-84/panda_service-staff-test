package wwf.org.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="rp_holidays")
@Data
public class Holidays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotNull(message = "holidayType_nula")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private HolidayType holidayType;

    @Temporal(TemporalType.DATE)
    private Date holiday;

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