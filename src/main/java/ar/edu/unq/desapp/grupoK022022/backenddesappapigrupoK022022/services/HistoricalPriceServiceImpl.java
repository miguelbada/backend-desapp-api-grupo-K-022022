package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.HistoricalPrice;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence.HistoricalPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalPriceServiceImpl implements HistoricalPriceService {
    @Autowired
    HistoricalPriceRepository repository;


    @Override
    public List<HistoricalPrice> getAllHistoricalPrices() {
        return repository.findAll();
    }

    @Override
    public HistoricalPrice saveHistoricalPrice(HistoricalPrice historicalPrice) {
        return repository.save(historicalPrice);
    }

    @Override
    public List<HistoricalPrice> getAllHistoricalPricesBySimbol(String simbol) {
        return repository.findAllByCrypto_Symbol(simbol);
    }


}
