package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserModelService {
    List<UserModel> findAllUsers();
    UserModel saveUser(UserModel user);
    UserModel getUserById(UUID id);
    void deleteUserById(UUID id);
    UserModel getUserByUsername(String username);
}
