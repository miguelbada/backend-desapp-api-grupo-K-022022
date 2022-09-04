package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String password;
    private String cvuMercadoPago;
    private String criptoWallet;

    public User() {
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
}
