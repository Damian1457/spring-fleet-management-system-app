package pl.wasik.damian.spring.app.fleet.management.system.accounts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.Transaction;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
