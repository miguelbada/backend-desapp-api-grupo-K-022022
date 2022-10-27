package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.UserModelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class UserModelController {

	@Autowired
	private UserModelServiceImpl userService;

	@Autowired
	private ModelMapper modelMapper;
	
	@Operation(summary = "List of all users of the application")
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> allUsers() {
		return ResponseEntity.ok().body(userService.findAllUsers().stream().map(this::convertUserModelEntityToUserDTO).collect(Collectors.toList()));
	}
	

	@Operation(summary = "Insert the information of a new user to the database")
	@PostMapping("/register")
	public ResponseEntity<UserModel> registerUser(@Valid @RequestBody UserDTO newUser) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(convertUserDtoToUserModelEntity(newUser)));
	}

	private UserDTO convertUserModelEntityToUserDTO(UserModel userModel) {
		return modelMapper.map(userModel, UserDTO.class);
	}

	private UserModel convertUserDtoToUserModelEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, UserModel.class);
	}
}
