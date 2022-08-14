package maktab74.service;

import maktab74.base.service.BaseService;
import maktab74.domain.Company;
import maktab74.util.CompanyBrif;

public interface CompanyService extends BaseService<Company,Long> {

   Company loginByUserNameAndPassword(CompanyBrif userBrif);

}
