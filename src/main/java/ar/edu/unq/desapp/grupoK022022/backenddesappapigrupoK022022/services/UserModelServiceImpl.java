package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services;

import java.util.List;
import java.util.UUID;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.exception.EmailAlreadyUsedException;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.exception.UserNotFoundException;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.persistence.UserModelRepository;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.security.JwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;

@Service
public class UserModelServiceImpl implements UserModelService {
	
	@Autowired
	UserModelRepository repository;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired 
	JwtProvider jwtProvider;


	@Override
	public List<UserModel> findAllUsers() {
		return (List<UserModel>) repository.findAll();
	}

	@Override
	public UserModel saveUser(UserModel user) {
		if (emailIsUsed(user.getEmail())) {
			throw new EmailAlreadyUsedException("Email: " + user.getEmail() + " is already used");
		}
		user.setPassword(encoder.encode(user.getPassword()));

		return repository.save(user);
	}

	@Override
	public UserModel getUserById(UUID id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found by id: " + id));
	}
	
	@Override
	public UserModel getUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public void deleteUserById(UUID id) {
		repository.deleteById(id);
	}

	@Override
	public UserModel getUserByUsername(String username) {
		return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found by username: " + username));
	}
	
	
	private Boolean emailIsUsed(String email) {
		UserModel user = getUserByEmail(email);
		return user != null;
	}

	public void deleteUserByUsername(String username) {
		repository.deleteByUsername(username);
		
	}
	 
}

