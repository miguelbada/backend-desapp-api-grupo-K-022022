package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Offer;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.OfferService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/offer")
public class OfferController {

    @Autowired
    private OfferService service;

    
    @Operation(summary = "List of all the Offers of the application")
    @GetMapping("/all/{username}")
    public ResponseEntity<List<Offer>> getAllOffersByUserName(@PathVariable String username) {
        List<Offer> offers = service
                .getAllOfferByUsername(username);
        return ResponseEntity.ok().body(offers);
    }

    
    @Operation(summary = "Get the information from the database of a Offer")
    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.getOfferById(id));
    }

    
    @Operation(summary = "Delete Offer information from the database")
    @DeleteMapping("/delete/{id}")
    public void deleteOfferById(@PathVariable UUID id) {
        service.deleteOfferById(id);
    }

 
	
}
