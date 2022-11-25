package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID>, JpaSpecificationExecutor<Offer> {

	@Query("SELECT o FROM Offer o WHERE CONCAT(o.username) LIKE %?1%")
	public List<Offer> search(String keyword);

}
