package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/binance/prices")
public class BinanceController {

	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = " (OK) Found the prices"),
			  @ApiResponse(responseCode = "401", description = " (Unauthorized) There is no authorization to call the service"),
	  		  @ApiResponse(responseCode = "404", description = " (Not Found) Information not found"),
	  		  @ApiResponse(responseCode = "500", description = " (Server Error)")})
	@Operation(summary = "Obtain the price of different crypto assets")
    @GetMapping
    public ResponseEntity<List<Object>> binancePrices() {
        String uri = "https://www.binance.com/api/v3/ticker/price";
        RestTemplate restTemplate = new RestTemplate();

        Object[] prices = restTemplate.getForObject(uri, Object[].class);

        return ResponseEntity.ok().body(Arrays.asList(prices));
    }
}
