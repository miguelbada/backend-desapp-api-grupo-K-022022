package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.HistoricalPrice;

import java.util.List;

public interface HistoricalPriceService {
    List<HistoricalPrice> getAllHistoricalPrices();
    HistoricalPrice saveHistoricalPrice(HistoricalPrice historicalPrice);
    List<HistoricalPrice> getAllHistoricalPricesBySimbol(String simbol);
}
