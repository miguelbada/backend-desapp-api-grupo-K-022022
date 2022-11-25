package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.HistoricalPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HistoricalPriceRepository extends JpaRepository<HistoricalPrice, UUID> {
    List<HistoricalPrice> findAllByCrypto_Symbol(String simbol);
}
