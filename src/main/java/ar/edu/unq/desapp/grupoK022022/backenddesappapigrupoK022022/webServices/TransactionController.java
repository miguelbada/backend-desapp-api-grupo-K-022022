package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.TransactionService;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices.dto.TransactionDTO;
import io.swagger.v3.oas.annotations.Operation;

import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper mapper;

    
    @Operation(summary = "Insert the information of a new transaction to the database")
    @PostMapping("/save")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody TransactionDTO newTransaction) {
        Transaction transaction = convertTransactionDtoToTransactionEntity(newTransaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveTransaction(transaction));
    }

    
    @Operation(summary = "List of all the transactions of the application")
    @GetMapping("/all")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> transactionsDTOs = service
                .getAllTransaction()
                .stream()
                .map(this::convertTransactionEntityToTransactionDTO)
                .toList();

        return ResponseEntity.ok().body(transactionsDTOs);
    }

    
    @Operation(summary = "Get the information from the database of a transaction")
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.getTransactionById(id));
    }

    
    @Operation(summary = "Delete transaction information from the database")
    @DeleteMapping("/delete/{id}")
    public void deleteTransactionById(@PathVariable UUID id) {
        service.deleteTransactionById(id);
    }

    
    private TransactionDTO convertTransactionEntityToTransactionDTO(Transaction transaction) {
        return mapper.map(transaction, TransactionDTO.class);
    }

    
    private Transaction convertTransactionDtoToTransactionEntity(TransactionDTO transactionDTO) {
        return mapper.map(transactionDTO, Transaction.class);
    }
}
