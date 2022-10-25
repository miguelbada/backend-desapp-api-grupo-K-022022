package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.builder;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.OperationType;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;


public class TransactionBuilder {
    public static TransactionBuilder aTransactionBuilder() {
        return new TransactionBuilder();
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

    public TransactionBuilder withType(final OperationType aType) {
        this.type = aType;
        return this;
    }

    public TransactionBuilder withCriptoActive(final String aCriptoActive) {
        this.criptoActive = aCriptoActive;
        return this;
    }

    public TransactionBuilder withCriptoActiveQuantity(final Double aCriptoActiveQuantity) {
        this.cryptoactiveQuantity = aCriptoActiveQuantity;
        return this;
    }

    public TransactionBuilder withCryptoAssetsQuote(final Double aCryptoAssetsQuote) {
        this.cryptoAssetsQuote = aCryptoAssetsQuote;
        return this;
    }

    public TransactionBuilder withArgentinePesos(final Double anArgentinePesos) {
        this.argentinePesos = anArgentinePesos;
        return this;
    }

    public TransactionBuilder withUsername(final String anUsername) {
        this.username = anUsername;
        return this;
    }
}
