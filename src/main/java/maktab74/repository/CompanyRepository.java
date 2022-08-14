package maktab74.repository;

import maktab74.base.repository.BaseRepository;
import maktab74.domain.Company;
import maktab74.util.CompanyBrif;

public interface CompanyRepository extends BaseRepository<Company,Long> {

    Company loginByUserNameAndPassword(CompanyBrif companyBrif);

}
