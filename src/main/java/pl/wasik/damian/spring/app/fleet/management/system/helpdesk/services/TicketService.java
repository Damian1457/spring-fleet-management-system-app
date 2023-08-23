package pl.wasik.damian.spring.app.fleet.management.system.helpdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.models.Ticket;
import pl.wasik.damian.spring.app.fleet.management.system.helpdesk.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository invoiceRepository;

    public List<Ticket> findAll() {
        return invoiceRepository.findAll();
    }

    public Optional<Ticket> findById(Long id) {
        return invoiceRepository.findById(id);
    }

    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

    public void save(Ticket invoice) {
        invoiceRepository.save(invoice);
    }
}