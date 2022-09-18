package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.IdGenerator;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.P2pSystem;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.User;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.UserService;

@RestController
@EnableAutoConfiguration
public class P2pRestService {

	@Autowired
	private UserService userService;
	
	private IdGenerator idGenerator = new IdGenerator();
	private P2pSystem p2pSystem = new P2pSystem(idGenerator);
	
	@GetMapping("/api/users")
	public ResponseEntity<?> allUsers() {
		List<User> list = otroMetodo();
		return ResponseEntity.ok().body(list);
	}

	private List<User> otroMetodo() {
		List<User> list = userService.findAll();
		return list;
	}
	
	@RequestMapping(value = "/api/version", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getVersion() {
		String version = "0.2.2";
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("version", version);
		return ResponseEntity.ok().body(resultado);
	}
	

	@RequestMapping(value = "/api/register", method = RequestMethod.POST)
	@PostMapping
	public void registerUser(@Valid @RequestBody UserDTO newUser) {
		User userRegister = p2pSystem.register(newUser.getName(),
											   newUser.getLastName(),
											   newUser.getEmail(),
											   newUser.getAddress(),
											   newUser.getPassword(),
											   newUser.getCvuMercadoPago(),
											   newUser.getCriptoWallet());
		userService.save(userRegister);
	}
}
