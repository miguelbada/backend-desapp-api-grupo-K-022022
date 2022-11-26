package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Crypto {
    @Id
    private String symbol;

    private Double price;
    private Double argentinePesos;
    private LocalDateTime dateTime;

    @OneToMany(mappedBy="crypto")
    @JsonManagedReference
    List<HistoricalPrice> historicalPrices;

    public Crypto() {
        this.dateTime = LocalDateTime.now();
        this.historicalPrices = new ArrayList<>();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getArgentinePesos() {
        return argentinePesos;
    }

    public void setArgentinePesos(Double argentinePesos) {
        this.argentinePesos = argentinePesos;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<HistoricalPrice> getHistoricalPrices() {
        return historicalPrices;
    }

    public void setHistoricalPrices(List<HistoricalPrice> historicalPrices) {
        this.historicalPrices = historicalPrices;
    }

    public HistoricalPrice createHistoricalPrice() {
        HistoricalPrice historicalPrice = new HistoricalPrice();
        historicalPrice.setCrypto(this);
        historicalPrice.setDateTime(LocalDateTime.now());
        historicalPrice.setPrice(this.price);

        this.historicalPrices.add(historicalPrice);

        return historicalPrice;
    }

    public void addHistoricalPrice(HistoricalPrice historicalPrice) {
        this.historicalPrices.add(historicalPrice);
    }

    public List<HistoricalPrice> getLastHs() {
        return this.historicalPrices
                .stream()
                .filter(h -> h.getDateTime().isAfter(LocalDateTime.now().minusHours(24)))
                .collect(Collectors.toList());
    }

}
