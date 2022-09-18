package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.User;

@Service
@Transactional
public class InitServiceInMemory {
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Value("${spring.datasource.driverClassName:NONE}")
	private String className;

	@Autowired
	private UserService userService;
	

	@PostConstruct
	public void initialize() {
		if (className.equals("org.h2.Driver")) {
			logger.info("Init Data Using H2 DB");
			fireInitialData();
		}
	}

	private void fireInitialData() {
		User user1 = new User(1, "Ivan", "San Martin", "ivan.sanmartin98@gmail.com", "Lisandro de la Torre 2985",
								"sanmartinfarias", "0000000000", "si");
		userService.save(user1);
		User user2 = new User(2, "Juan", "Farias", "juan.farias@gmail.com", "9 de Julio",
				"juanfarias", "1111111111", "si");
		userService.save(user2);

		
		

	}

}
