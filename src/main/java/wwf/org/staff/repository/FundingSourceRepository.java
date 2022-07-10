package wwf.org.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwf.org.staff.entity.FundingSource;

public interface FundingSourceRepository extends JpaRepository<FundingSource, Long> {

    public FundingSource findByNumberFundingSource(String val);
}
