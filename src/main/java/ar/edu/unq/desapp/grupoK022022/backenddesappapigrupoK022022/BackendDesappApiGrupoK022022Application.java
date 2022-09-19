package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BackendDesappApiGrupoK022022Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendDesappApiGrupoK022022Application.class, args);
	}

}
