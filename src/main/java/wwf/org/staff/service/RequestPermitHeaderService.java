package wwf.org.staff.service;

import wwf.org.staff.entity.RequestPermitHeader;

import java.util.Date;
import java.util.List;

public interface RequestPermitHeaderService {
    public List<RequestPermitHeader> listAllRequestPermitHeader();
    public RequestPermitHeader getRequestPermitHeader(Long id);

    public RequestPermitHeader createRequestPermitHeader(RequestPermitHeader requestPermitHeader);

    public RequestPermitHeader generateNumberRequest(RequestPermitHeader header);
    public String generateMd5(String text);
    public RequestPermitHeader updateRequestPermitHeader(RequestPermitHeader requestPermitHeader);
    public Boolean deleteRequestPermitHeader(Long id);

    public RequestPermitHeader findByNumberSolict(String numberSolict);
    public List<RequestPermitHeader> findByUserId(Long userId);

    public List<RequestPermitHeader> findStatusRequest(Number state, Long userId);
    public List<RequestPermitHeader> findStatusRequestTo(Number state, Date dateTo, Long userId);
    public List<RequestPermitHeader> findStatusRequestFrom(Number state, Date dateFrom, Long userId);
    public List<RequestPermitHeader> findStatusRequestFromTo(Number state, Date dateFrom, Date dateTo, Long userId);
    public List<RequestPermitHeader> findStatusRequestDate(Date dateFrom, Date dateTo, Long userId);
    public List<RequestPermitHeader> findStatusRequestPendientes(Long userId);
}
