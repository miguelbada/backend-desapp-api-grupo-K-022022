package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import java.util.List;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Transactional
	public User save(User data) {
		return this.repository.save(data);
	}

	public User findByID(Integer id) {
		return this.repository.findById(id).get();
	}

	@Transactional
	public List<User> findAll() {
		return this.repository.findAll();
	}
}

