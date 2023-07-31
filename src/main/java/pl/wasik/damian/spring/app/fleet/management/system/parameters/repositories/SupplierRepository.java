package pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}