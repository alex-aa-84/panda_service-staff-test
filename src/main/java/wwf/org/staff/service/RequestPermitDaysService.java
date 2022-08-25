package wwf.org.staff.service;

import wwf.org.staff.entity.RequestPermitDays;

import java.util.List;

public interface RequestPermitDaysService {
    public List<RequestPermitDays> listAllRequestPermitDays();
    public RequestPermitDays getRequestPermitDays(Long id);

    public RequestPermitDays createRequestPermitDays(RequestPermitDays requestPermitDays);
    public RequestPermitDays updateRequestPermitDays(RequestPermitDays requestPermitDays);
    public Boolean deleteRequestPermitDays(Long id);
}
