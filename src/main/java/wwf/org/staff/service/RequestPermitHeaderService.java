package wwf.org.staff.service;

import wwf.org.staff.entity.RequestPermitHeader;

import java.util.List;

public interface RequestPermitHeaderService {
    public List<RequestPermitHeader> listAllRequestPermitHeader();
    public RequestPermitHeader getRequestPermitHeader(Long id);

    public RequestPermitHeader createRequestPermitHeader(RequestPermitHeader requestPermitHeader);
    public RequestPermitHeader updateRequestPermitHeader(RequestPermitHeader requestPermitHeader);
    public Boolean deleteRequestPermitHeader(Long id);
}
