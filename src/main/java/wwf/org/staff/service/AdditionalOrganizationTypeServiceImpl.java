package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.AdditionalOrganizationType;
import wwf.org.staff.repository.AdditionalOrganizationTypeRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdditionalOrganizationTypeServiceImpl implements AdditionalOrganizationTypeService{

    @Autowired
    private AdditionalOrganizationTypeRepository relationshipRepository;

    @Override
    public List<AdditionalOrganizationType> listAllAdditionalOrganizationType() {
        return relationshipRepository.findAll();
    }

    @Override
    public AdditionalOrganizationType getAdditionalOrganizationType(Long id) {
        return relationshipRepository.findById(id).orElse(null);
    }

    @Override
    public AdditionalOrganizationType createAdditionalOrganizationType(AdditionalOrganizationType additionalOrganizationType) {
        additionalOrganizationType.setStatus("CREATED");
        additionalOrganizationType.setCreation_date(new Date());
        additionalOrganizationType.setLast_update_date(new Date());

        return relationshipRepository.save(additionalOrganizationType);
    }

    @Override
    public AdditionalOrganizationType updateAdditionalOrganizationType(AdditionalOrganizationType additionalOrganizationType) {
        AdditionalOrganizationType relationshipDB = getAdditionalOrganizationType(additionalOrganizationType.getId());
        if(null == relationshipDB){
            return null;
        }

        relationshipDB.setName(additionalOrganizationType.getName());
        relationshipDB.setDescription(additionalOrganizationType.getDescription());

        relationshipDB.setAttribute1(additionalOrganizationType.getAttribute1());
        relationshipDB.setAttribute2(additionalOrganizationType.getAttribute2());
        relationshipDB.setAttribute3(additionalOrganizationType.getAttribute3());
        relationshipDB.setAttribute4(additionalOrganizationType.getAttribute4());
        relationshipDB.setAttribute5(additionalOrganizationType.getAttribute5());
        relationshipDB.setAttribute6(additionalOrganizationType.getAttribute6());
        relationshipDB.setAttribute7(additionalOrganizationType.getAttribute7());
        relationshipDB.setAttribute8(additionalOrganizationType.getAttribute8());
        relationshipDB.setAttribute9(additionalOrganizationType.getAttribute9());
        relationshipDB.setAttribute10(additionalOrganizationType.getAttribute10());

        relationshipDB.setStatus(additionalOrganizationType.getStatus());

        relationshipDB.setLast_update_by(additionalOrganizationType.getLast_update_by());
        relationshipDB.setLast_update_date(new Date());

        return relationshipRepository.save(relationshipDB);
    }

    @Override
    public Boolean deleteAdditionalOrganizationType(Long id) {
        AdditionalOrganizationType relationshipDB = getAdditionalOrganizationType(id);
        if(null == relationshipDB){
            return false;
        }

        relationshipRepository.deleteById(id);
        return true;
    }

    @Override
    public AdditionalOrganizationType findByName(String name) {
        return relationshipRepository.findByName(name);
    }
}
