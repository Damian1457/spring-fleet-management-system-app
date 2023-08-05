package pl.wasik.damian.spring.app.fleet.management.system.fleet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.fleet.management.system.fleet.models.VehicleHire;

@Repository
public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {

}
