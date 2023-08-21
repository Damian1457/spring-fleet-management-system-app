package pl.wasik.damian.spring.app.fleet.management.system.accounts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.InvoiceStatus;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.repositories.InvoiceStatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> findAll() {
        return invoiceStatusRepository.findAll();
    }

    public Optional<InvoiceStatus> findById(Long id) {
        return invoiceStatusRepository.findById(id);
    }

    public void delete(Long id) {
        invoiceStatusRepository.deleteById(id);
    }

    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }
}
