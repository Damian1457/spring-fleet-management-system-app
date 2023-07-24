package pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
