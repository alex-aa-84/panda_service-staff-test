package wwf.org.staff.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import wwf.org.staff.entity.RequestPermitHeader;

public interface RequestPermitHeaderRepository extends JpaRepository<RequestPermitHeader, Long> {

    public RequestPermitHeader findByNumberSolict(String numberSolict);
    public List<RequestPermitHeader> findByUserId(Long userId);


    @Query("SELECT p FROM RequestPermitHeader p inner join p.workflowSteps s where s.workflowStateId = ?1 and p.userId = ?2")
    public List<RequestPermitHeader> findStatusRequest(Number state, Long userId);

    @Query("SELECT p FROM RequestPermitHeader p inner join p.workflowSteps s where s.workflowStateId = ?1 and p.dateRequest <= ?2 and p.userId = ?3")
    public List<RequestPermitHeader> findStatusRequestTo(Number state, Date dateTo, Long userId);

    @Query("SELECT p FROM RequestPermitHeader p inner join p.workflowSteps s where s.workflowStateId = ?1 and p.dateRequest >= ?2 and p.userId = ?3")
    public List<RequestPermitHeader> findStatusRequestFrom(Number state, Date dateFrom, Long userId);

    @Query("SELECT p FROM RequestPermitHeader p inner join p.workflowSteps s where s.workflowStateId = ?1 and p.dateRequest between ?2 and ?3 and p.userId = ?4")
    public List<RequestPermitHeader> findStatusRequestFromTo(Number state, Date dateFrom, Date dateTo, Long userId);

    @Query("SELECT p FROM RequestPermitHeader p where p.dateRequest between ?1 and ?2 and p.userId = ?3")
    public List<RequestPermitHeader> findStatusRequestDate(Date dateFrom, Date dateTo, Long userId);

    @Query("SELECT p FROM RequestPermitHeader p inner join p.workflowSteps s where s.workflowStateId not in (4, 5) and p.userId = ?1")
    public List<RequestPermitHeader> findStatusRequestPendientes(Long userId);

}
