package pl.wasik.damian.spring.app.fleet.management.system.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.models.TicketStatus;

@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Long> {
}
