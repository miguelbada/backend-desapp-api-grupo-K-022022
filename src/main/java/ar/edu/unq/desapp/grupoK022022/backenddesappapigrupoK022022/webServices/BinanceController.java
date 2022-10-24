package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/binance/prices")
public class BinanceController {

    @GetMapping
    public ResponseEntity<List<Object>> binancePrices() {
        String uri = "https://www.binance.com/api/v3/ticker/price";
        RestTemplate restTemplate = new RestTemplate();

        Object[] prices = restTemplate.getForObject(uri, Object[].class);

        return ResponseEntity.ok().body(Arrays.asList(prices));
    }
}
