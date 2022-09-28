package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Basic
    private LocalDateTime date;

    private OperationType type;
    private String criptoActive;
    private Double cryptoactiveQuantity;
    private Double cryptoAssetsQuote;
    private Double argentinePesos;
    private String username;
    private Integer trades;
    private String reputation;

    public Transaction() {
        this.date = getCurrentDate();
    }

    public Transaction(OperationType type, String criptoActive, Double cryptoactiveQuantity, Double cryptoAssetsQuote, Double argentinePesos, String username) {
        this.date = getCurrentDate();
        this.type = type;
        this.criptoActive = criptoActive;
        this.cryptoactiveQuantity = cryptoactiveQuantity;
        this.cryptoAssetsQuote = cryptoAssetsQuote;
        this.argentinePesos = argentinePesos;
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCriptoActive() {
        return criptoActive;
    }

    public void setCriptoActive(String criptoActive) {
        this.criptoActive = criptoActive;
    }

    public Double getCryptoactiveQuantity() {
        return cryptoactiveQuantity;
    }

    public void setCryptoactiveQuantity(Double cryptoactiveQuantity) {
        this.cryptoactiveQuantity = cryptoactiveQuantity;
    }

    public Double getArgentinePesos() {
        return argentinePesos;
    }

    public void setArgentinePesos(Double amoungArgentinePesos) {
        this.argentinePesos = amoungArgentinePesos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getCryptoAssetsQuote() {
        return cryptoAssetsQuote;
    }

    public void setCryptoAssetsQuote(Double cryptoAssetsQuote) {
        this.cryptoAssetsQuote = cryptoAssetsQuote;
    }

    public Integer getTrades() {
        return trades;
    }

    public void setTrades(Integer amountOfTrades) {
        this.trades = amountOfTrades;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    private LocalDateTime getCurrentDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        String text = dateTime.format(formatter);

        return LocalDateTime.parse(text, formatter);
    }
}
