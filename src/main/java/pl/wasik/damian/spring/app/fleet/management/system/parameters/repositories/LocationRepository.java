package pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
