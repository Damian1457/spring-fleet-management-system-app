package pl.wasik.damian.spring.app.fleet.management.system.hr.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person {

    @ManyToOne
    @JoinColumn(name = "employeetypeid", insertable = false, updatable = false)
    private EmployeeType employeeType;
    private Long employeetypeid;
    private String photo;
    private String username;

    @ManyToOne
    @JoinColumn(name = "jobtitleid", insertable = false, updatable = false)
    private JobTitle jobTitle;
    private Long jobtitleid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
}
