package maktab74.domain;

import maktab74.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ticket_table")
public class Ticket extends BaseEntity<Long> {

    private String origin;
    private String destination;
    private Long price ;
    private Long number ;
    @ManyToOne
    private Company company ;

    public Ticket() {
    }

    public Ticket(String origin, String destination, Long price, Long number, Company company) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.number = number;
        this.company = company;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return
                getId()+")"+
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", company=" + company ;
    }
}

