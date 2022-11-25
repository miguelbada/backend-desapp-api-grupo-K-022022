package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DataLoader {
    private UserModel user1;
    private UserModel user2;
    private RoleModel role1;
    private RoleModel role2;


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

    public List<Transaction> getTransactions() {
        Transaction transaction1 = user1.transactionIntent(OperationType.SALE, "ETHBTC", 4.0, 0.06975300, 209259.0, "miguel");
        Transaction transaction2 = user2.transactionIntent(OperationType.SALE, "BTCPLN", 1.0, 96897.00000000, 29069100.00, "Martin");
        Transaction transaction3 = user1.transactionIntent(OperationType.SALE, "ETHPLN", 1.0, 6792.00000000, 2037600.00, "Enzo");
        Transaction transaction4 = user2.transactionIntent(OperationType.PURCHASE, "APTBUSD", 5.0, 9.49470000, 27000.00, "Jose");
        Transaction transaction5 = user1.transactionIntent(OperationType.PURCHASE, "POLYXUSDT", 10.0, 0.18190000, 540.00, "Ernesto");
        Transaction transaction6 = user2.transactionIntent(OperationType.PURCHASE, "APTBTC", 25.0, 0.00049019, 3.68, "Juan");

        return new ArrayList<>((Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5, transaction6)));
    }

}
