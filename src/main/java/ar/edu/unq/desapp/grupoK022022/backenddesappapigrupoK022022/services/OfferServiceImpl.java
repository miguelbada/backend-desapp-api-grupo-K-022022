package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Offer;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.exception.UserNotFoundException;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService{

    @Autowired
    OfferRepository repository;

    @Override
    public Offer saveOffer(Offer offer) {
        return repository.save(offer);
    }

    @Override
    public List<Offer> getAllOffer() {
        return repository.findAll();
    }
    

    @Override
    public Offer getOfferById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Offer not found by id: " + id));
    }

    @Override
    public void deleteOfferById(UUID id) {
        repository.deleteById(id);
    }
    
    @Override
    public List<Offer> getAllOfferByUsername(String username) {
    	if (username != null) {
    		return repository.search(username);
    	}
        return new ArrayList<Offer>();
    }
}

