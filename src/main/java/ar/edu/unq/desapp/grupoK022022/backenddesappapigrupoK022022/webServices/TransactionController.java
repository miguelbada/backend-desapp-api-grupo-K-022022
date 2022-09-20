package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping("/save")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveTransaction(transaction));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok().body(service.getAllTransaction());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.getTransactionById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransactionById(@PathVariable UUID id) {
        service.deleteTransactionById(id);
    }
}
