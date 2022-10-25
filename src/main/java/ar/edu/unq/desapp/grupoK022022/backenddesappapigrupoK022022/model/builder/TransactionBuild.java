package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.builder;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.OperationType;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;


public class TransactionBuild {
    public static TransactionBuild aTransactionBuilder() {
        return new TransactionBuild();
    }

    private OperationType type;
    private String criptoActive;
    private Double cryptoactiveQuantity;
    private Double cryptoAssetsQuote;
    private Double argentinePesos;
    private String username;

    public Transaction built() {
        return new Transaction(type, criptoActive, cryptoactiveQuantity, cryptoAssetsQuote, argentinePesos, username);
    }

    public TransactionBuild withType(final OperationType aType) {
        this.type = aType;
        return this;
    }

    public TransactionBuild withCriptoActive(final String aCriptoActive) {
        this.criptoActive = aCriptoActive;
        return this;
    }

    public TransactionBuild withCriptoActiveQuantity(final Double aCriptoActiveQuantity) {
        this.cryptoactiveQuantity = aCriptoActiveQuantity;
        return this;
    }

    public TransactionBuild withCryptoAssetsQuote(final Double aCryptoAssetsQuote) {
        this.cryptoAssetsQuote = aCryptoAssetsQuote;
        return this;
    }

    public TransactionBuild withArgentinePesos(final Double anArgentinePesos) {
        this.argentinePesos = anArgentinePesos;
        return this;
    }

    public TransactionBuild withUsername(final String anUsername) {
        this.username = anUsername;
        return this;
    }
}
