package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
    @ApiResponses(value = { 
    		  @ApiResponse(responseCode = "200", description = " (OK) A new transaction was saved"),
    		  @ApiResponse(responseCode = "400", description = " (Bad Request) The data sent is incorrect or there is required data not sent"),
    		  @ApiResponse(responseCode = "401", description = " (Unauthorized) There is no authorization to call the service"),
    		  @ApiResponse(responseCode = "404", description = " (Not Found) Information not found"),
    		  @ApiResponse(responseCode = "500", description = " (Server Error)")})
    @PostMapping("/save")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody TransactionDTO newTransaction) {

        Transaction transaction = convertTransactionDtoToTransactionEntity(newTransaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveTransaction(transaction));
    }

    
    @Operation(summary = "List of all the transactions of the application")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = " (OK) Found the all transctions"),
			  @ApiResponse(responseCode = "401", description = " (Unauthorized) There is no authorization to call the service"),
	  		  @ApiResponse(responseCode = "404", description = " (Not Found) Information not found"),
	  		  @ApiResponse(responseCode = "500", description = " (Server Error)")})
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
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = " (OK) Found the specific transaction"),
			  @ApiResponse(responseCode = "401", description = " (Unauthorized) There is no authorization to call the service"),
	  		  @ApiResponse(responseCode = "404", description = " (Not Found) Information not found"),
	  		  @ApiResponse(responseCode = "500", description = " (Server Error)")})
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.getTransactionById(id));
    }

    
    @Operation(summary = "Delete transaction information from the database")
    @ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = " (OK) Delete the specific transaction"),
			  @ApiResponse(responseCode = "401", description = " (Unauthorized) There is no authorization to call the service"),
	  		  @ApiResponse(responseCode = "404", description = " (Not Found) Information not found"),
	  		  @ApiResponse(responseCode = "500", description = " (Server Error)")})
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
