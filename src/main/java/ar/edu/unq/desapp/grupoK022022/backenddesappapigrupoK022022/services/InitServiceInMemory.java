package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.DataLoader;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.Transaction;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence.RoleModelRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InitServiceInMemory {
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Value("${spring.datasource.driverClassName:NONE}")
	private String className;

	@Autowired
	private UserModelServiceImpl userService;

	@Autowired
	private RoleModelRepository roleRepository;

	@Autowired
	private TransactionService transactionService;
	

	@PostConstruct
	public void initialize() {
		if (className.equals("org.h2.Driver")) {
			logger.info("Init Data Using H2 DB");
			fireInitialData();
		}
	}

	private void fireInitialData() {
		DataLoader dataLoader = new DataLoader();

		roleRepository.save(dataLoader.getRole1());
		roleRepository.save(dataLoader.getRole2());

		userService.saveUser(dataLoader.getUser1());
		userService.saveUser(dataLoader.getUser2());

		List<Transaction> transactions = new DataLoader().getTransactions();
		transactions.forEach(transaction -> transactionService.saveTransaction(transaction));
	}

}
