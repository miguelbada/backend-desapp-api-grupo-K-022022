package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BackendDesappApiGrupoK022022Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendDesappApiGrupoK022022Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
