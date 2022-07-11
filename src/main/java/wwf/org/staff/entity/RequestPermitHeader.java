package wwf.org.staff.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="rp_request_permit_header")
@Data
public class RequestPermitHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
}
