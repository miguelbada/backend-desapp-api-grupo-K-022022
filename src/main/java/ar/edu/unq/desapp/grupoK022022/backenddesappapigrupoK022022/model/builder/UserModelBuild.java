package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.builder;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.RoleModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserModelBuild {
    public static UserModelBuild aUserModel() {
        return new UserModelBuild();
    }

    private String name = "no name";
    private String lastName = "no lastName";
    private List<RoleModel> roles = new ArrayList<>();
    private String username = "no username";
    private String email = "no email";
    private String address = "no address";
    private String password= "no password";
    private String cvuMercadoPago = "no cvuMercadoPago";
    private String criptoWallet = "no criptoWallet";

    public UserModel built() {
        return new UserModel(name, lastName, username, email, address, password, cvuMercadoPago, criptoWallet);
    }

    public UserModelBuild withName(final String aName) {
        this.name = aName;
        return this;
    }

    public UserModelBuild withLastName(final String aLastName) {
        this.lastName = aLastName;
        return this;
    }

    public UserModelBuild withRole(final RoleModel aRoleModel) {
        this.roles.add(aRoleModel);
        return this;
    }

    public UserModelBuild withUsername(final String aUsername) {
        this.username = aUsername;
        return this;
    }

    public UserModelBuild withEmail(final String aEmail) {
        this.email = aEmail;
        return this;
    }

    public UserModelBuild withAddress(final String aAddress) {
        this.address = aAddress;
        return this;
    }

    public UserModelBuild withPassword(final String aPassword) {
        this.password = aPassword;
        return this;
    }

    public UserModelBuild withCvuMercadoPago(final String aCvuMercadoPago) {
        this.cvuMercadoPago = aCvuMercadoPago;
        return this;
    }

    public UserModelBuild withCriptoWallet(final String aCriptoWallet) {
        this.criptoWallet = aCriptoWallet;
        return this;
    }
}
