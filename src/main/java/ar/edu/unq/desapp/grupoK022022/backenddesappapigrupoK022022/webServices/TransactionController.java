package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.TransactionService;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.UserModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @Autowired
    private UserModelService userService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody TransactionDTO newTransaction) {

        Transaction transaction = convertTransactionDtoToTransactionEntity(newTransaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveTransaction(transaction));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> transactionsDTOs = service
                .getAllTransaction()
                .stream()
                .map(this::convertTransactionEntityToTransactionDTO)
                .toList();

        return ResponseEntity.ok().body(transactionsDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.getTransactionById(id));
    }

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
