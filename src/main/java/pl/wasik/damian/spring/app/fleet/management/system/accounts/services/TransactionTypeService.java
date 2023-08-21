package pl.wasik.damian.spring.app.fleet.management.system.accounts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.TransactionType;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.repositories.TransactionTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTypeService {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public List<TransactionType> findAll() {
        return transactionTypeRepository.findAll();
    }

    public Optional<TransactionType> findById(Long id) {
        return transactionTypeRepository.findById(id);
    }

    public void delete(Long id) {
        transactionTypeRepository.deleteById(id);
    }

    public void save(TransactionType transactionType) {
        transactionTypeRepository.save(transactionType);
    }
}
