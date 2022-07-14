package wwf.org.staff.service;

import wwf.org.staff.entity.RequestType;

import java.util.List;

public interface RequestPermitTypeService {
    public List<RequestType> listAllRequestPermitType();
    public RequestType getRequestPermitType(Long id);

    public RequestType createRequestPermitType(RequestType requestType);
    public RequestType updateRequestPermitType(RequestType requestType);
    public Boolean deleteRequestPermitType(Long id);

    public RequestType findByName(String name);
}
