package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
