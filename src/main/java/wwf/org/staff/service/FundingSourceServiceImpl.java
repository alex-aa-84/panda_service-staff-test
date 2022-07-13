package wwf.org.staff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wwf.org.staff.entity.FundingSource;
import wwf.org.staff.repository.FundingSourceRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FundingSourceServiceImpl implements FundingSourceService{

    @Autowired
    private FundingSourceRepository repository;


    @Override
    public List<FundingSource> listAllFundingSource() {
        return repository.findAll();
    }

    @Override
    public FundingSource getFundingSource(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public FundingSource createFundingSource(FundingSource value) {
        value.setStatus("CREATED");
        value.setCreation_date(new Date());
        value.setLast_update_date(new Date());

        return repository.save(value);
    }

    @Override
    public FundingSource updateFundingSource(FundingSource value) {
        FundingSource bd = getFundingSource(value.getId());
        if(null == bd){
            return null;
        }

        bd.setNumberFundingSource(value.getNumberFundingSource());
        bd.setName(value.getName());
        bd.setUserId(value.getUserId());
        bd.setContractStartDate(bd.getContractStartDate());
        bd.setContractEndDate(value.getContractEndDate());
        bd.setProjects(value.getProjects());
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
    public Boolean deleteFundingSource(Long id) {
        FundingSource bd = getFundingSource(id);
        if(null == bd){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public FundingSource findByNumberFundingSource(String val) {
        return repository.findByNumberFundingSource(val);
    }
}
