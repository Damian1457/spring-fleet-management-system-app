package pl.wasik.damian.spring.app.fleet.management.system.fleet.models;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.CommonObject;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class VehicleModel extends CommonObject {

}
