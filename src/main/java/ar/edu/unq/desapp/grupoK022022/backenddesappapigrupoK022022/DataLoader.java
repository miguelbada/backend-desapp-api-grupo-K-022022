package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DataLoader {
    private UserModel user1;
    private UserModel user2;
    private RoleModel role1;
    private RoleModel role2 = new RoleModel();
    //private List<offer> offers;

    public DataLoader() {
        this.role1 = new RoleModel();
        role1.setName(RoleType.ROLE_ADMIN);

        this.role2 = new RoleModel();
        role2.setName(RoleType.ROLE_USER);

        this.user1 = new UserModel("Ivan", "San Martin", "sanmartinfarias", "ivan.sanmartin98@gmail.com", "Lisandro de la Torre 2985",
                "sanmartinfarias", "0000000000", "si");
        this.user1.addRoleModel(role1);

        this.user2 = new UserModel("Juan", "Farias", "juanfarias", "juan.farias@gmail.com", "9 de Julio",
                "juanfarias", "1111111111", "si");
        this.user2.addRoleModel(role2);


    }

    public RoleModel getRole1() {
        return role1;
    }

    public RoleModel getRole2() {
        return role2;
    }

    public UserModel getUser1() {
        return user1;
    }

    public UserModel getUser2() {
        return user2;
    }

    public List<Offer> getOffers() {
        Offer offer1 = user1.createOffer("ETHBTC", 4.0, 0.06975300, 209259.0, "miguel", OperationType.SALE);
        Offer offer2 = user2.createOffer("BTCPLN", 1.0, 96897.00000000, 29069100.00, "Martin",OperationType.SALE);
        Offer offer3 = user1.createOffer("ETHPLN", 1.0, 6792.00000000, 2037600.00, "Enzo",OperationType.SALE);
        Offer offer4 = user2.createOffer("APTBUSD", 5.0, 9.49470000, 27000.00, "Jose", OperationType.PURCHASE);
        Offer offer5 = user1.createOffer("POLYXUSDT", 10.0, 0.18190000, 540.00, "Ernesto",OperationType.PURCHASE);
        Offer offer6 = user2.createOffer("APTBTC", 25.0, 0.00049019, 3.68, "Juan", OperationType.PURCHASE);

        return new ArrayList<>((Arrays.asList(offer1, offer2, offer3, offer4, offer5, offer6)));
    }

}
