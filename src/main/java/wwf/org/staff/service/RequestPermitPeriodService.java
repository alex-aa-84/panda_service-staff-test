package wwf.org.staff.service;

import wwf.org.staff.entity.RequestPermitPeriods;

import java.util.List;

public interface RequestPermitPeriodService {
    public List<RequestPermitPeriods> listAllRequestPermitPeriods();
    public RequestPermitPeriods getRequestPermitPeriods(Long id);

    public RequestPermitPeriods createRequestPermitPeriods(RequestPermitPeriods requestPermitPeriods);
    public RequestPermitPeriods updateRequestPermitPeriods(RequestPermitPeriods requestPermitPeriods);
    public Boolean deleteRequestPermitPeriods(Long id);
}
