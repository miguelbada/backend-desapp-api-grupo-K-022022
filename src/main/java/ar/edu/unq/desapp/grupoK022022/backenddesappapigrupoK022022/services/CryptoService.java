package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Crypto;

import java.util.List;
import java.util.Optional;

public interface CryptoService {
    List<Crypto> getBinanceCryptos();
    void initialiceCryptos();
    Crypto saveCrypto(Crypto crypto);
    List<String> getSimbols();
    Optional<Crypto> getCryptoBySimbol(String simbol);
    List<Crypto> saveAllCryptos(List<Crypto> cryptos);
    List<Crypto> getAllCryptos();
}
