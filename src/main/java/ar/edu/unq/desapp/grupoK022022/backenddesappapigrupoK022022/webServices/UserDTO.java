package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.ValidPassword;

public class UserDTO {
	
    public String getCriptoWallet() {
        return criptoWallet;
    }

    public String getCvuMercadoPago() {
        return cvuMercadoPago;
    }
    
    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getName() {
        return name;
    }
	
    
    @Size(min = 3, max = 30, message = "Invalid length for name")
    private String name;
    
    @Size(min = 3, max = 30, message = "Invalid length for last name")
    private String lastName;
    
    @Email 
    private String email;
    
    @Size(min = 10, max = 30, message = "Invalid length for address")
    private String address;
    
    @Size(min = 6, message = "The password is less than 6 characters")
    @ValidPassword
    private String password;
    
    @Size(min = 22, max = 22, message = "Invalid length for CVU")
    private String cvuMercadoPago;
    
    @Size(min = 8, max = 8, message = "Invalid length for wallet")
    private String criptoWallet;
    
    
    public UserDTO() {
    	super();
    }
    
    public UserDTO(
    		String name,
		    String lastName,
		    String email,
		    String address, 
		    String password,
		    String cvuMercadoPago,
		    String criptoWallet) {
    	super();
    	this.name = name;
    	this.lastName = lastName;
    	this.email = email;
    	this.address = address;
    	this.password = password;
    	this.cvuMercadoPago = cvuMercadoPago;
    	this.criptoWallet = criptoWallet;			
    }
    
    

}
