package pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
