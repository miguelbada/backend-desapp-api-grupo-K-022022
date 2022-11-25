package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Offer;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.OfferState;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID>, JpaSpecificationExecutor<Offer> {

	@Query("SELECT o FROM Offer o WHERE o.username = ?1 and o.state = ?2")
	public List<Offer> search(String keyword, OfferState keyword2);

}
