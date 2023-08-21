package pl.wasik.damian.spring.app.fleet.management.system.accounts.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.CommonObject;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TransactionType extends CommonObject {
}
