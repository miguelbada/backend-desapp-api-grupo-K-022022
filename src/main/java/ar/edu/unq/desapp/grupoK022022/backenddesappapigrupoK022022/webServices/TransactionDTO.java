package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.OperationType;

public class TransactionDTO {

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
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

	private OperationType type;

	private String criptoActive;
	
    private Double cryptoactiveQuantity;
    
    private Double cryptoAssetsQuote;
    
    private Double argentinePesos;
    
    private String username;
    
    private Integer trades;
    
    private String reputation;
	
    
    public TransactionDTO() {
    	super();
    }
    
}
