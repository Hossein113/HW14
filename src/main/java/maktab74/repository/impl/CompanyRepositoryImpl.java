package maktab74.repository.impl;

import maktab74.base.repository.impl.BaseRepositoryImple;
import maktab74.domain.Company;
import maktab74.repository.CompanyRepository;
import maktab74.util.CompanyBrif;

import javax.persistence.EntityManager;

public class CompanyRepositoryImpl extends BaseRepositoryImple<Company,Long> implements CompanyRepository {
    public CompanyRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Company> getEntityClass() {
        return Company.class;
    }

    @Override
    public Company loginByUserNameAndPassword(CompanyBrif companyBrif) {
        return entityManager.createQuery("select c from Company c where c.userName =:userName and " +
                        "c.password =:password", Company.class).setParameter("userName", companyBrif.getUserName())
                .setParameter("password", companyBrif.getPassword()).getSingleResult();
    }
}
