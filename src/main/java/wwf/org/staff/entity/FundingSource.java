package wwf.org.staff.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import wwf.org.staff.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ts_funding_source")
@Data
public class FundingSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numberFundingSource;

    @Column(nullable = false)
    private String name;

    @Column(name = "user_manager")
    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date contractStartDate ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date contractEndDate ;

    @Transient
    private User user;

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
