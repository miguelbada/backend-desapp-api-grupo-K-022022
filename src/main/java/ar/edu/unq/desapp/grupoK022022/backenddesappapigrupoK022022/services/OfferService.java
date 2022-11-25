package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import java.util.List;
import java.util.UUID;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Offer;

public interface OfferService {

    Offer saveOffer(Offer offer);
    List<Offer> getAllOffer();
    Offer getOfferById(UUID id);
    void deleteOfferById(UUID id);
    List<Offer> getAllOfferByUsername(String username);
	
}
