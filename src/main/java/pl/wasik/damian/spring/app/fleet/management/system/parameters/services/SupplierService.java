package pl.wasik.damian.spring.app.fleet.management.system.parameters.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.models.Supplier;
import pl.wasik.damian.spring.app.fleet.management.system.parameters.repositories.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }
}
