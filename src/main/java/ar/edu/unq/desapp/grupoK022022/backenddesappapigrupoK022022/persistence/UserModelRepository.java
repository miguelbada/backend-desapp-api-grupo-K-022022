package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByUsername(String username);

	UserModel findByEmail(String email);

	void deleteByUsername(String username);
}


