package maktab74.service.impl;

import maktab74.base.service.impl.BaseServiceImpl;
import maktab74.domain.Company;
import maktab74.domain.Ticket;
import maktab74.repository.CompanyRepository;
import maktab74.repository.TicketRepository;
import maktab74.service.CompanyService;
import maktab74.service.TicketService;
import maktab74.util.CompanyBrif;

public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long , TicketRepository> implements TicketService {


    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }
}

