package pl.wasik.damian.spring.app.fleet.management.system.accounts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.models.TransactionStatus;
import pl.wasik.damian.spring.app.fleet.management.system.accounts.repositories.TransactionStatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionStatusService {

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    public List<TransactionStatus> findAll() {
        return transactionStatusRepository.findAll();
    }

    public Optional<TransactionStatus> findById(Long id) {
        return transactionStatusRepository.findById(id);
    }

    public void delete(Long id) {
        transactionStatusRepository.deleteById(id);
    }

    public void save(TransactionStatus transactionStatus) {
        transactionStatusRepository.save(transactionStatus);
    }
}
