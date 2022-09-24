package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.RolType;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.RoleModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence.RoleModelRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class InitServiceInMemory {
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Value("${spring.datasource.driverClassName:NONE}")
	private String className;

	@Autowired
	private UserModelServiceImpl userService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private RoleModelRepository roleRepository;
	

	@PostConstruct
	public void initialize() {
		if (className.equals("org.h2.Driver")) {
			logger.info("Init Data Using H2 DB");
			fireInitialData();
		}
	}

	private void fireInitialData() {
		UserModel user1 = new UserModel("Ivan", "San Martin", "sanmartinfarias", "ivan.sanmartin98@gmail.com", "Lisandro de la Torre 2985",
				encoder.encode("sanmartinfarias"), "0000000000", "si");

		RoleModel role1 = new RoleModel();
		role1.setName(RolType.ROLE_ADMIN);

		user1.addRoleModel(role1);

		roleRepository.save(role1);
		userService.saveUser(user1);

        UserModel user2 = new UserModel("Juan", "Farias", "juanfarias", "juan.farias@gmail.com", "9 de Julio",
				encoder.encode("juanfarias"), "1111111111", "si");

		RoleModel role2 = new RoleModel();
		role2.setName(RolType.ROLE_USER);

		user2.addRoleModel(role2);

		roleRepository.save(role2);
		userService.saveUser(user2);
	}

}
