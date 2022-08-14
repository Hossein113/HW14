package maktab74;

import maktab74.domain.Company;
import maktab74.domain.Ticket;
import maktab74.util.*;

import javax.persistence.EntityManagerFactory;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        System.out.println("ssss");
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        System.out.println("doun");
        while (true) {
            menu(applicationContext);
        }
    }

    private static void menu(ApplicationContext applicationContext) {
        ShowMenu.showMenu();
        int number = applicationContext.getIntegerScanner().nextInt();
        try {


            if (number == 1) {
                company(applicationContext);
            } else if (number == 2) {
                showAllTicket(applicationContext);
            } else {
                ShowMenu.wrong();
                menu(applicationContext);
            }
        } catch (Exception e) {
            ShowMenu.wrong();
            applicationContext.getIntegerScanner().next();
            menu(applicationContext);
        }
    }

    private static void showAllTicket(ApplicationContext applicationContext) {
        List<Ticket> all = applicationContext.getTicketRepository().findAll();
        all.forEach(System.out::println);

    }

    private static void company(ApplicationContext applicationContext) {
        try {


            ShowMenu.showCompanyMenu();
            int number = applicationContext.getIntegerScanner().nextInt();

            if (number == 1) {
                registerCompany(applicationContext);
                company(applicationContext);
            } else if (number == 2) {
                loginCompani(applicationContext);
            } else if (number == 3) {
                menu(applicationContext);

            } else {
                ShowMenu.wrong();
                company(applicationContext);
            }
        } catch (Exception e) {
            ShowMenu.wrong();
            applicationContext.getIntegerScanner().next();
            company(applicationContext);
        }
    }

    private static void loginCompani(ApplicationContext applicationContext) {

        ShowMenu.enterUserName();
        String userName = applicationContext.getStringScanner().nextLine();
        ShowMenu.enterPassword();
        String password = applicationContext.getStringScanner().nextLine();
        CompanyBrif companyBrif = new CompanyBrif(userName, password);

        Company companyCurent = applicationContext.getCompanyService().loginByUserNameAndPassword(companyBrif);
        if (companyCurent != null) {

            ShowMenu.printWelcomeToProfile(companyCurent);
            applicationContext.getSecurityCompany().setCurentCompany(companyCurent);
            loginMenuCompany(applicationContext, companyCurent);
        } else {
            ShowMenu.wroungUserNameOrPassword();
            menu(applicationContext);
        }
    }

    private static void loginMenuCompany(ApplicationContext applicationContext, Company companyCurent) {

        ShowMenu.loginCompany();
        int number = applicationContext.getIntegerScanner().nextInt();
        try {
            if (number == 1) {
                addTicket(applicationContext, companyCurent);
                loginMenuCompany(applicationContext, companyCurent);
            } else if (number == 2) {
                applicationContext.getSecurityCompany().logout();

            } else if (number == 3) {
                menu(applicationContext);

            } else {
                ShowMenu.wrong();
                company(applicationContext);
            }
        } catch (Exception e) {
            ShowMenu.wrong();
            applicationContext.getIntegerScanner().next();
            company(applicationContext);
        }
    }

    private static void addTicket(ApplicationContext applicationContext, Company company) {
        ShowMenu.enterOrigin();
        String origin = applicationContext.getStringScanner().next();
        ShowMenu.destination();
        String destination = applicationContext.getStringScanner().next();
        ShowMenu.price();
        Long price = Long.valueOf(applicationContext.getIntegerScanner().nextInt());
        ShowMenu.number();
        Long number = Long.valueOf(applicationContext.getIntegerScanner().nextInt());
        Ticket ticket = new Ticket(origin, destination, price, number, company);
        applicationContext.getTicketRepository().save(ticket);
        ShowMenu.successfully();
    }

    private static void exit(SecurityCompany companyCurent) {
        companyCurent.logout();

    }


    private static void registerCompany(ApplicationContext applicationContext) {

        ShowMenu.enterNameCompany();
        String Name = applicationContext.getStringScanner().nextLine();
        ShowMenu.enterUserName();
        String userName = applicationContext.getStringScanner().nextLine();
        ShowMenu.enterPassword();
        String password = applicationContext.getStringScanner().nextLine();

        Company company = new Company();
        company.setName(Name);

        company.setUserName(userName);
        company.setPassword(password);
        applicationContext.getCompanyRepository().save(company);
        ShowMenu.successfully();
    }
}
        