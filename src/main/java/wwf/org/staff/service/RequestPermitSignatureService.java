package wwf.org.staff.service;

import wwf.org.staff.entity.RequestPermitSignature;

import java.util.List;

public interface RequestPermitSignatureService {
    public List<RequestPermitSignature> listAllRequestPermitSignature();
    public RequestPermitSignature getRequestPermitSignature(Long id);

    public RequestPermitSignature createRequestPermitSignature(RequestPermitSignature requestPermitSignature);
    public RequestPermitSignature updateRequestPermitSignature(RequestPermitSignature requestPermitSignature);
    public Boolean deleteRequestPermitSignature(Long id);
}
