package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCvuMercadoPago() {
        return cvuMercadoPago;
    }

    public void setCvuMercadoPago(String cvuMercadoPago) {
        this.cvuMercadoPago = cvuMercadoPago;
    }

    public String getCriptoWallet() {
        return criptoWallet;
    }

    public void setCriptoWallet(String criptoWallet) {
        this.criptoWallet = criptoWallet;
    }

    public String reputation() {
        if(this.operations == 0 || this.score == 0) {
            return "Sin operaciones";
        } else {
            return Double.valueOf(this.score / this.operations).toString();
        }

    }

    public Transaction transactionIntent(String criptoActive, Double cryptoactiveQuantity, Double cryptoAssetsQuote, Double amoungArgentinePesos, String username, OperationTypes transactionTypes) {
        return new Transaction(criptoActive, cryptoactiveQuantity, cryptoAssetsQuote, amoungArgentinePesos, username, this.operations, this.reputation());
    }
    
    @Id
    private Integer id;
    
    @Column
    private String name;
    
    @Column
    private String lastName;
    
    @Column
    private String email;
    
    @Column
    private String address;
    
    @Column
    private String password;
    
    @Column
    private String cvuMercadoPago;
    
    @Column
    private String criptoWallet;

    private Integer score;
    private Integer operations;
    
    
    public User() {
    	super();
    }
    
    public User(
    		Integer id,
    		String name,
		    String lastName,
		    String email,
		    String address, 
		    String password,
		    String cvuMercadoPago,
		    String criptoWallet) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.lastName = lastName;
    	this.email = email;
    	this.address = address;
    	this.password = password;
    	this.cvuMercadoPago = cvuMercadoPago;
    	this.criptoWallet = criptoWallet;
        this.score = 0;
        this.operations = 0;
    }

}
