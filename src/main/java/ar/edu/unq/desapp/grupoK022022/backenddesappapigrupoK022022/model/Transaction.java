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
    //@Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    private String criptoActive;
    private Double cryptoactiveQuantity;
    private Double cryptoAssetsQuote;
    private Double amoungArgentinePesos;
    private String username;
    private Integer trades;
    private String reputation;

    public Transaction() {
        this.date = getCurrentDate();
    }

    public Transaction(String criptoActive, Double cryptoactiveQuantity, Double cryptoAssetsQuote, Double amoungArgentinePesos, String username, Integer trades, String reputation) {
        this.date = getCurrentDate();
        this.criptoActive = criptoActive;
        this.cryptoactiveQuantity = cryptoactiveQuantity;
        this.cryptoAssetsQuote = cryptoAssetsQuote;
        this.amoungArgentinePesos = amoungArgentinePesos;
        this.username = username;
        this.trades = trades;
        this.reputation = reputation;
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

    public Double getAmoungArgentinePesos() {
        return amoungArgentinePesos;
    }

    public void setAmoungArgentinePesos(Double amoungArgentinePesos) {
        this.amoungArgentinePesos = amoungArgentinePesos;
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

    private LocalDateTime getCurrentDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        String text = dateTime.format(formatter);

        return LocalDateTime.parse(text, formatter);
    }
}
