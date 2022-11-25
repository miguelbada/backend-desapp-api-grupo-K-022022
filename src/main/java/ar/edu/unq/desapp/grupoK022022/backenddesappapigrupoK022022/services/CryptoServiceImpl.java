package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Crypto;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.HistoricalPrice;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence.CryptoRepository;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence.HistoricalPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CryptoServiceImpl implements CryptoService{
    @Autowired
    CryptoRepository repository;

    @Autowired
    HistoricalPriceRepository historicalPriceRepository;

    @Override
    public List<Crypto> getBinanceCryptos() {
        String uri = "https://www.binance.com/api/v3/ticker/price";
        RestTemplate restTemplate = new RestTemplate();
        Crypto[] prices = restTemplate.getForObject(uri, Crypto[].class);

        return Arrays.stream(prices).filter(c -> this.getSimbols().contains(c.getSymbol())).collect(Collectors.toList());
    }

    @Override
    @Scheduled(fixedRate = 6000)
    public void initialiceCryptos() {
        List<Crypto> cryptos = getBinanceCryptos();

        repository.saveAll(cryptos);

        for (Crypto crypto : cryptos) {
            historicalPriceRepository.save(crypto.createHistoricalPrice());
        }
    }

    @Override
    public Crypto saveCrypto(Crypto crypto) {
        return repository.save(crypto);
    }

    @Override
    public List<String> getSimbols() {
        return new ArrayList<>(List.of(
                "ALICEUSDT",
                "MATICUSDT",
                "AXSUSDT",
                "AAVEUSDT",
                "ATOMUSDT",
                "NEOUSDT",
                "DOTUSDT",
                "ETHUSDT",
                "CAKEUSDT",
                "BTCUSDT",
                "BNBUSDT",
                "ADAUSDT",
                "TRXUSDT",
                "AUDIOUSDT"
        ));
    }

    @Override
    public Optional<Crypto> getCryptoBySimbol(String simbol) {
        return repository.findBySymbol(simbol);
    }

    @Override
    public List<Crypto> saveAllCryptos(List<Crypto> criptos) {
        return repository.saveAll(criptos);
    }

    @Override
    public List<Crypto> getAllCryptos() {
        return repository.findAll();
    }

}
