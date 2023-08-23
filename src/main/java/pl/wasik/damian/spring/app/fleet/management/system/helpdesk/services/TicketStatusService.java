package pl.wasik.damian.spring.app.fleet.management.system.helpdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.models.TicketStatus;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.repositories.TicketStatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketStatusService {

    @Autowired
    private TicketStatusRepository ticketStatusRepository;

    public List<TicketStatus> findAll() {
        return ticketStatusRepository.findAll();
    }

    public Optional<TicketStatus> findById(Long id) {
        return ticketStatusRepository.findById(id);
    }

    public void delete(Long id) {
        ticketStatusRepository.deleteById(id);
    }

    public void save(TicketStatus ticketStatus) {
        ticketStatusRepository.save(ticketStatus);
    }
}