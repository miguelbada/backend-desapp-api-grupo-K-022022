package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.UserModelServiceImpl;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.services.security.JwtProvider;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices.dto.TokenDTO;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices.dto.UserDTO;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices.dto.UserLoginDTO;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@Transactional
@RequestMapping("/api")
public class UserModelController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;	
    
	@Autowired
    private JwtProvider jwtProvider;
	
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

	
	@Operation(summary = "Start a user session")
	@PostMapping("login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserLoginDTO request) {
       // try {
        	
        	UserModel user = userService.getUserByUsername(request.getUserName());
        	
            authenticationManager
                .authenticate(
                    new UsernamePasswordAuthenticationToken(
                        request.getUserName(), request.getPassword()
                    )
                );
        	
            final UserDetails userDetails = userDetailsService.loadUserByUsername(
                    request.getUserName());

            final String jwt = jwtProvider.generateToken(userDetails);

            TokenDTO tokenInfo = new TokenDTO(jwt);
            
            return ResponseEntity.ok()
                .header(
                    HttpHeaders.AUTHORIZATION,
                    tokenInfo.getJwtToken()
                )
                .body(modelMapper.map(user, UserDTO.class));
    }
	
	@Operation(summary = "Delete user information from the database")
    @DeleteMapping("/delete/{username}")
    public void deleteUserByUserName(@PathVariable String username) {
        userService.deleteUserByUsername(username);
    }


	
	private UserDTO convertUserModelEntityToUserDTO(UserModel userModel) {
		return modelMapper.map(userModel, UserDTO.class);
	}

	private UserModel convertUserDtoToUserModelEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, UserModel.class);
	}
}
