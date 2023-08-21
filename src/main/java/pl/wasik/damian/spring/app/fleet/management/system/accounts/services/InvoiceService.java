package pl.wasik.damian.spring.app.fleet.management.system.accounts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.Invoice;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.repositories.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }
}
