package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.AdditionalOrganization;
import wwf.org.staff.repository.AdditionalOrganizationRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdditionalOrganizationServiceImpl implements AdditionalOrganizationService{

    @Autowired
    private AdditionalOrganizationRepository repository;


    @Override
    public List<AdditionalOrganization> listAllAdditionalOrganization() {
        return repository.findAll();
    }

    @Override
    public AdditionalOrganization getAdditionalOrganization(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AdditionalOrganization createAdditionalOrganization(AdditionalOrganization value) {
        value.setStatus("CREATED");
        value.setCreation_date(new Date());
        value.setLast_update_date(new Date());

        return repository.save(value);
    }

    @Override
    public AdditionalOrganization updateAdditionalOrganization(AdditionalOrganization value) {
        AdditionalOrganization bd = getAdditionalOrganization(value.getId());
        if(null == bd){
            return null;
        }

        bd.setTenantId(value.getTenantId());
        bd.setFromTime(value.getFromTime());
        bd.setUntilTime(value.getUntilTime());
        bd.setFromMonth(value.getFromMonth());
        bd.setUntilMonth(value.getUntilMonth());
        bd.setValue(value.getValue());

        bd.setDescription(value.getDescription());

        bd.setAttribute1(value.getAttribute1());
        bd.setAttribute2(value.getAttribute2());
        bd.setAttribute3(value.getAttribute3());
        bd.setAttribute4(value.getAttribute4());
        bd.setAttribute5(value.getAttribute5());
        bd.setAttribute6(value.getAttribute6());
        bd.setAttribute7(value.getAttribute7());
        bd.setAttribute8(value.getAttribute8());
        bd.setAttribute9(value.getAttribute9());
        bd.setAttribute10(value.getAttribute10());

        bd.setStatus(value.getStatus());

        bd.setLast_update_by(value.getLast_update_by());
        bd.setLast_update_date(new Date());

        return repository.save(bd);
    }

    @Override
    public Boolean deleteAdditionalOrganization(Long id) {
        AdditionalOrganization bd = getAdditionalOrganization(id);
        if(null == bd){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public AdditionalOrganization findByTenantIdAndAdditionalOrganizationTypeIdAndFromTimeAndUntilTimeAndFromMonthAndUntilMonthAndValue(Long tenantId, Long additionalOrganizationTypeId, Integer fromTime, Integer untilTime, Integer fromMonth, Integer untilMonth, Integer value) {
        return repository.findByTenantIdAndAdditionalOrganizationTypeIdAndFromTimeAndUntilTimeAndFromMonthAndUntilMonthAndValue(tenantId, additionalOrganizationTypeId, fromTime, untilTime, fromMonth, untilMonth, value);
    }


}
