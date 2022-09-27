package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;
import java.util.List;
import java.util.UUID;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> getAllTransaction();
    Transaction getTransactionById(UUID id);
    void deleteTransactionById(UUID id);
}
