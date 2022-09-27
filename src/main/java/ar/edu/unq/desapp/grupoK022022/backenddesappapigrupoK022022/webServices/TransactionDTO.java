package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

public class TransactionDTO {

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

	private String criptoActive;
	
    private Double cryptoactiveQuantity;
    
    private Double cryptoAssetsQuote;
    
    private Double amoungArgentinePesos;
    
    private String username;
    
    private Integer trades;
    
    private String reputation;
	
    
    public TransactionDTO() {
    	super();
    }
    
}
