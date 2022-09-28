package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model;

import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
public class UserModel implements UserDetails {

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }

    public void addRoleModel(RoleModel roleModel) {
        this.roles.add(roleModel);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getOperations() {
        return operations;
    }

    public void setOperations(Integer operations) {
        this.operations = operations;
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
        	return Float.toString(Float.valueOf(this.score) / this.operations);
        }

    }

    public Transaction transactionIntent(OperationType type, String criptoActive, Double cryptoactiveQuantity, Double cryptoAssetsQuote, Double amoungArgentinePesos, String username) {
        return new Transaction(type, criptoActive, cryptoactiveQuantity, cryptoAssetsQuote, amoungArgentinePesos, username);
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    private String name;
    private String lastName;

    @ManyToMany
    @JoinTable(name = "userModel_roleModel",
            joinColumns = @JoinColumn(name = "userModel_id"),
            inverseJoinColumns = @JoinColumn(name = "roleModel_id"))
    private List<RoleModel> roles;

    @Column(nullable = false, unique = true)
    private String username;

    private String email;
    private String address;

    @Column(nullable = false)
    private String password;

    private String cvuMercadoPago;
    private String criptoWallet;
    private Integer score;
    private Integer operations;

    public UserModel() {
        super();
        this.roles = new ArrayList<>();
    }

    public UserModel(
            String name,
            String lastName,
            String username,
            String email,
            String address,
            String password,
            String cvuMercadoPago,
            String criptoWallet) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.address = address;
        this.password = password;
        this.cvuMercadoPago = cvuMercadoPago;
        this.criptoWallet = criptoWallet;
        this.score = 0;
        this.operations = 0;
        this.roles = new ArrayList<>();
    }
}
