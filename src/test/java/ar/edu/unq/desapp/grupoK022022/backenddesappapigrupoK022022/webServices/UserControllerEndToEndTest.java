package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices.dto.UserLoginDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.URI;


@SuppressWarnings("deprecation")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerEndToEndTest {

	private static final String HTTP_LOCALHOST = "http://localhost:";

	@LocalServerPort
	private String port;

	@Autowired
	private UserModelController controller;

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void getListOfUsersSuccessfullyTest() throws Exception {

		ResponseEntity<String> result = restTemplate.getForEntity(HTTP_LOCALHOST + port + "/api/users", String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void getListOfUsersSuccessfullyWithTheirPropertiesTest() throws Exception {

		ResponseEntity<String> result = restTemplate.getForEntity(HTTP_LOCALHOST + port + "/api/users", String.class);

		assertTrue(result.getBody().contains("username"));
		assertTrue(result.getBody().contains("password"));
		assertTrue(result.getBody().contains("email"));
	}

	@Test
	public void registerNewUserSuccessfullyTest() throws Exception {

		final String baseUrl = "http://localhost:"+port+"/api/register";
        URI uri = new URI(baseUrl);

		UserModel newUser = new UserModel("Fulano",
										  "Cosme",
										  "FulanoCosme", 
										  "fulanocosme@gmail.com",
										  "Av falsa 123",
										  "BadPassword8.",
										  "2222222222222222222222",
										  "88888888");


		ResponseEntity<String> result = restTemplate.postForEntity(uri, newUser, String.class);

		assertEquals(201, result.getStatusCodeValue());

		assertTrue(result.getBody().contains("Fulano"));
		assertTrue(result.getBody().contains("Cosme"));
		assertTrue(result.getBody().contains("fulanocosme@gmail.com"));
	}

	@Test
	public void loginExistUserSuccessfullyTest() throws Exception {

		final String baseUrl = "http://localhost:"+port+"/api/login";
        URI uri = new URI(baseUrl);

        UserLoginDTO newLogin = new UserLoginDTO("sanmartinfarias", "sanmartinfarias");

        ResponseEntity<String> result = restTemplate.postForEntity(uri, newLogin, String.class);

        assertEquals(200, result.getStatusCodeValue());

        assertTrue(result.getHeaders().containsKey("Authorization"));
	}

	@Test
	public void loginNonExistentUserWithErrorMessageTest() throws Exception {

		final String baseUrl = "http://localhost:"+port+"/api/login";
        URI uri = new URI(baseUrl);

        UserLoginDTO newLogin = new UserLoginDTO("farias", "farias");

        ResponseEntity<String> result = restTemplate.postForEntity(uri, newLogin, String.class);

        assertEquals(400, result.getStatusCodeValue());

        assertFalse(result.getHeaders().containsKey("Authorization"));

		assertTrue(result.getBody().contains("User not found by username: farias"));
	}

}












