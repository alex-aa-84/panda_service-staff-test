package wwf.org.staff.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="ts_timesheet_lines")
@Data
public class TimesheetLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
}
