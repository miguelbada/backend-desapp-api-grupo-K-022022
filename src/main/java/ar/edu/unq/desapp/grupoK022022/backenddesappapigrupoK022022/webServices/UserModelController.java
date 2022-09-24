package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.UserModelServiceImpl;

@RestController
@RequestMapping("/api")
public class UserModelController {

	@Autowired
	private UserModelServiceImpl userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserModel>> allUsers() {
		return ResponseEntity.ok().body(userService.findAllUsers());
	}
	
	@RequestMapping(value = "/version", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getVersion() {
		String version = "0.2.2";
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("version", version);
		return ResponseEntity.ok().body(resultado);
	}

	@PostMapping("/register")
	public UserModel registerUser(@Valid @RequestBody UserModel newUser) {
		/*User userRegister = new User(newUser.getName(),
												newUser.getLastName(),
											    newUser.getEmail(),
											    newUser.getAddress(),
											    newUser.getPassword(),
											    newUser.getCvuMercadoPago(),
											    newUser.getCriptoWallet());*/
		return userService.saveUser(newUser);
	}
}
