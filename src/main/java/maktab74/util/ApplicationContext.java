package maktab74.util;

import maktab74.repository.CompanyRepository;
import maktab74.repository.TicketRepository;
import maktab74.repository.impl.CompanyRepositoryImpl;
import maktab74.repository.impl.TicketRepositoryImpl;
import maktab74.service.CompanyService;
import maktab74.service.TicketService;
import maktab74.service.impl.CompanyServiceImpl;
import maktab74.service.impl.TicketServiceImpl;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ApplicationContext {

    private static final EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();



    private Scanner stringScanner;

    private Scanner integerScanner ;

    private CompanyRepository companyRepository ;

    private CompanyService companyService ;

    private SecurityCompany securityCompany;

    private TicketRepository ticketRepository ;

    private TicketService ticketService ;



    public Scanner getStringScanner() {

            if (stringScanner == null) {
                stringScanner = new Scanner(System.in);
            }
        return stringScanner;
    }

    public Scanner getIntegerScanner() {
                if(integerScanner == null){
                    integerScanner = new Scanner(System.in);
        }
        return integerScanner;
    }

    public CompanyRepository getCompanyRepository() {
        if(companyRepository==null){
            companyRepository=new CompanyRepositoryImpl(em);
        }
        return companyRepository;
    }

    public CompanyService getCompanyService() {
        if(companyService==null){
            companyService=new CompanyServiceImpl(getCompanyRepository());
        }
        return companyService;
    }

    public SecurityCompany getSecurityCompany() {
        if(securityCompany==null){
            securityCompany=new SecurityCompany();
        }
        return securityCompany;
    }

    public TicketRepository getTicketRepository() {
        if(ticketRepository==null){
            ticketRepository= new TicketRepositoryImpl(em);
        }
        return ticketRepository;
    }

    public TicketService getTicketService() {
        if (ticketService==null){
            ticketService=new TicketServiceImpl(getTicketRepository());
        }
        return ticketService;
    }
}


