package pl.wasik.damian.spring.app.fleet.management.system.accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
