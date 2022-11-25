package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, String> {
    Optional<Crypto> findBySymbol(String simbol);
}
