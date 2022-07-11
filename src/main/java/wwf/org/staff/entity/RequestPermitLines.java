package wwf.org.staff.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="rp_request_permit_lines")
@Data
public class RequestPermitLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
}