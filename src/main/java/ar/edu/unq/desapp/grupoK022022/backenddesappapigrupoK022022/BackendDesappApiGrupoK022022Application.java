package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "CriptoP2P", version = "1.0", description = "P2P service to buy cryptocurrencies between people, with the aim of generating a trusted community to be able to exchange cryptocurrencies for argentine money"))
public class BackendDesappApiGrupoK022022Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendDesappApiGrupoK022022Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
