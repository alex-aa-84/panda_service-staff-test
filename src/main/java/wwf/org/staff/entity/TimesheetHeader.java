package wwf.org.staff.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="ts_timesheet_header")
@Data
public class TimesheetHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
}
