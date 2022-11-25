package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Crypto;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.HistoricalPrice;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.CryptoService;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.HistoricalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/binance")
public class BinanceController {
    @Autowired
    CryptoService service;

    @Autowired
    HistoricalPriceService historicalPriceService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " (OK) Found the prices"),
            @ApiResponse(responseCode = "401", description = " (Unauthorized) There is no authorization to call the service"),
            @ApiResponse(responseCode = "404", description = " (Not Found) Information not found"),
            @ApiResponse(responseCode = "500", description = " (Server Error)")})
    @Operation(summary = "Obtain the price of different crypto assets")
    @GetMapping("/prices")
    public ResponseEntity<List<Crypto>> prices() {
        return ResponseEntity.ok().body(service.getBinanceCryptos());
    }

    @GetMapping("/cryptos")
    public ResponseEntity<List<Crypto>> getAllCryptos() {
        return ResponseEntity.ok().body(service.getAllCryptos());
    }

    @GetMapping("/last24/{simbol}")
    public ResponseEntity<List<HistoricalPrice>> lastHs(@PathVariable String simbol) {
        return ResponseEntity.ok().body(service.getCryptoBySimbol(simbol).get().getLastHs());
    }

    @GetMapping("testHistorical")
    public List<HistoricalPrice> getAllHistorical() {
        return historicalPriceService.getAllHistoricalPrices();
    }

}
