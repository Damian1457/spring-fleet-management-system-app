package pl.wasik.damian.spring.app.fleet.management.system.accounts.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import pl.wasik.damian.spring.app.fleet.management.system.hr.models.Employee;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Client;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Contact;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Supplier;

import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String purpose;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "transactionstatusid", insertable = false, updatable = false)
    private TransactionStatus transactionStatus;
    private Long transactionstatusid;

    @ManyToOne
    @JoinColumn(name = "transactiontypeid", insertable = false, updatable = false)
    private TransactionType transactionType;
    private Long transactiontypeid;

    @ManyToOne
    @JoinColumn(name = "contactid", insertable = false, updatable = false)
    private Contact contact;
    private Long contactid;

    @ManyToOne
    @JoinColumn(name = "supplierid", insertable = false, updatable = false)
    private Supplier supplier;
    private Long supplierid;

    @ManyToOne
    @JoinColumn(name = "clientid", insertable = false, updatable = false)
    private Client client;
    private Long clientid;

    @ManyToOne
    @JoinColumn(name = "employeeid", insertable = false, updatable = false)
    private Employee approvedBy;
    private Long employeeid;

    private String remarks;
}
