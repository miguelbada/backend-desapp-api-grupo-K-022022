package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Offer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    private String criptoActive;
    private Double cryptoactiveQuantity;
    private Double cryptoAssetsQuote;
    private Double argentinePesos;
    private String username;
    private OperationType type;
	private OfferState state;
    @Basic
    private LocalDateTime date;
    private Integer trades;
	private String reputation;

  
	public Offer(String criptoActive, 
				 Double cryptoactiveQuantity,
				 Double cryptoAssetsQuote,
				 Double argentinePesos,
				 String username,
				 OperationType type) {
		
		this.criptoActive = criptoActive;
	    this.cryptoactiveQuantity = cryptoactiveQuantity;
	    this.cryptoAssetsQuote = cryptoAssetsQuote;
	    this.argentinePesos = argentinePesos;
	    this.username = username;
	    this.type =  type;
		this.state = OfferState.OPEN;
		this.date = getCurrentDate();
			
	}
	

    public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public Double getCryptoAssetsQuote() {
		return cryptoAssetsQuote;
	}
	public void setCryptoAssetsQuote(Double cryptoAssetsQuote) {
		this.cryptoAssetsQuote = cryptoAssetsQuote;
	}
	public Double getArgentinePesos() {
		return argentinePesos;
	}
	public void setArgentinePesos(Double argentinePesos) {
		this.argentinePesos = argentinePesos;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public OperationType getType() {
		return type;
	}
	public void setType(OperationType type) {
		this.type = type;
	}
	public OfferState getState() {
		return state;
	}
	public void setState(OfferState state) {
		this.state = state;
	}
    public Integer getTrades() {
		return trades;
	}
	public void setTrades(Integer trades) {
		this.trades = trades;
	}
	public String getReputation() {
		return reputation;
	}
	public void setReputation(String reputation) {
		this.reputation = reputation;
	}
	public LocalDateTime getDate() {
		return date;
	}
	
	
    private LocalDateTime getCurrentDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        String text = dateTime.format(formatter);

        return LocalDateTime.parse(text, formatter);
    }
    
    public Offer () {
    	this.state = OfferState.OPEN;
    	this.date = getCurrentDate();
    }

}
