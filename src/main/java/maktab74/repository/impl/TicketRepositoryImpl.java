package maktab74.repository.impl;

import maktab74.base.repository.impl.BaseRepositoryImple;
import maktab74.domain.Company;
import maktab74.domain.Ticket;
import maktab74.repository.CompanyRepository;
import maktab74.repository.TicketRepository;
import maktab74.util.CompanyBrif;

import javax.persistence.EntityManager;

public class TicketRepositoryImpl extends BaseRepositoryImple<Ticket,Long> implements TicketRepository {

    public TicketRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}

