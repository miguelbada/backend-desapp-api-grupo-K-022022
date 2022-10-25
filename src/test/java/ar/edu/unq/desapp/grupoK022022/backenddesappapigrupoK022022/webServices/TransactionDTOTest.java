package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.OperationType;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.builder.TransactionBuild;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TransactionDTOTest {
    private final TransactionBuild transactionBuilder = new TransactionBuild();
    private final ModelMapper mapper = new ModelMapper();

    @Test
    public void convertTransactionEntityToTransactionDTO() {
        Transaction transaction = transactionBuilder
                .withType(OperationType.PURCHASE)
                .withCriptoActive("BiteCoin")
                .withCriptoActiveQuantity(0.8)
                .withCryptoAssetsQuote(1.7)
                .withArgentinePesos(900.7)
                .withUsername("marce970")
                .built();

        TransactionDTO transactionDTO = mapper.map(transaction, TransactionDTO.class);

        assertEquals(transactionDTO.getType(), transaction.getType());
        assertEquals(transactionDTO.getCriptoActive(), transaction.getCriptoActive());
        assertEquals(transactionDTO.getCryptoactiveQuantity(), transaction.getCryptoactiveQuantity());
        assertEquals(transactionDTO.getCryptoAssetsQuote(), transaction.getCryptoAssetsQuote());
        assertEquals(transactionDTO.getArgentinePesos(), transaction.getArgentinePesos());
        assertEquals(transactionDTO.getUsername(), transaction.getUsername());
    }

    @Test
    public void convertTransactionDTOToTransactionEntity() {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setType(OperationType.SALE);
        transactionDTO.setCriptoActive("Ethereum");
        transactionDTO.setCryptoactiveQuantity(4.6);
        transactionDTO.setCryptoAssetsQuote(6.1);
        transactionDTO.setArgentinePesos(1340.67);
        transactionDTO.setUsername("lucas4578");

        Transaction transaction = mapper.map(transactionDTO, Transaction.class);

        assertEquals(transaction.getType(), transactionDTO.getType());
        assertEquals(transaction.getCriptoActive(), transactionDTO.getCriptoActive());
        assertEquals(transaction.getCryptoactiveQuantity(), transactionDTO.getCryptoactiveQuantity());
        assertEquals(transaction.getCryptoAssetsQuote(), transactionDTO.getCryptoAssetsQuote());
        assertEquals(transaction.getArgentinePesos(), transactionDTO.getArgentinePesos());
        assertEquals(transaction.getUsername(), transactionDTO.getUsername());
    }
}
