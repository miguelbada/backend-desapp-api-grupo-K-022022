package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.builder;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.RoleModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserModelBuilder {
    public static UserModelBuilder aUserModel() {
        return new UserModelBuilder();
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

    public UserModelBuilder withName(final String aName) {
        this.name = aName;
        return this;
    }

    public UserModelBuilder withLastName(final String aLastName) {
        this.lastName = aLastName;
        return this;
    }

    public UserModelBuilder withRole(final RoleModel aRoleModel) {
        this.roles.add(aRoleModel);
        return this;
    }

    public UserModelBuilder withUsername(final String aUsername) {
        this.username = aUsername;
        return this;
    }

    public UserModelBuilder withEmail(final String aEmail) {
        this.email = aEmail;
        return this;
    }

    public UserModelBuilder withAddress(final String aAddress) {
        this.address = aAddress;
        return this;
    }

    public UserModelBuilder withPassword(final String aPassword) {
        this.password = aPassword;
        return this;
    }

    public UserModelBuilder withCvuMercadoPago(final String aCvuMercadoPago) {
        this.cvuMercadoPago = aCvuMercadoPago;
        return this;
    }

    public UserModelBuilder withCriptoWallet(final String aCriptoWallet) {
        this.criptoWallet = aCriptoWallet;
        return this;
    }
}
