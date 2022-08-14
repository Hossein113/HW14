package maktab74.util;

import maktab74.base.domain.BaseEntity;
import maktab74.domain.Company;

public class SecurityCompany extends BaseEntity<Long> {

        private Company curentCompany;

    public SecurityCompany() {
        this.curentCompany = curentCompany;
    }

    public Company getCurentCompany() {
        return curentCompany;
    }
public void logout(){
        this.curentCompany=null;
}
    public void setCurentCompany(Company curentCompany) {
        this.curentCompany = curentCompany;
    }
}
