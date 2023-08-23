package pl.wasik.damian.spring.app.fleet.management.system.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.wasik.damian.spring.app.fleet.management.system.hr.models.Employee;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String details;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date openDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date closeDate;

    @ManyToOne
    @JoinColumn(name = "ticketstatusid", insertable = false, updatable = false)
    private TicketStatus ticketStatus;
    private Long ticketstatusid;

    @ManyToOne
    @JoinColumn(name = "employeeid", insertable = false, updatable = false)
    private Employee raisedBy;
    private Long employeeid;

    @ManyToOne
    @JoinColumn(name = "employeeid", insertable = false, updatable = false)
    private Employee asignedTo;

    private String remarks;
}