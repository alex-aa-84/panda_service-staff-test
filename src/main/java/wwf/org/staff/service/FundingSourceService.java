package wwf.org.staff.service;

import wwf.org.staff.entity.FundingSource;

import java.util.List;

public interface FundingSourceService {

    public List<FundingSource> listAllFundingSource();

    public FundingSource getFundingSource(Long id);

    public FundingSource createFundingSource(FundingSource value);
    public FundingSource updateFundingSource(FundingSource value);
    public Boolean deleteFundingSource(Long id);

    public FundingSource findByNumberFundingSource(String numberfundingsource);

}
