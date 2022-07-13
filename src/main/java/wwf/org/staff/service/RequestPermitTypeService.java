package wwf.org.staff.service;

import wwf.org.staff.entity.RequestPermitType;

import java.util.List;

public interface RequestPermitTypeService {
    public List<RequestPermitType> listAllRequestPermitType();
    public RequestPermitType getRequestPermitType(Long id);

    public RequestPermitType createRequestPermitType(RequestPermitType requestPermitType);
    public RequestPermitType updateRequestPermitType(RequestPermitType requestPermitType);
    public Boolean deleteRequestPermitType(Long id);

    public RequestPermitType findByName(String name);
}
