package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.exception.UserNotFoundException;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository repository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return repository.findAll();
    }

    @Override
    public Transaction getTransactionById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found by id: " + id));
    }

    @Override
    public void deleteTransactionById(UUID id) {
        repository.deleteById(id);
    }
}
