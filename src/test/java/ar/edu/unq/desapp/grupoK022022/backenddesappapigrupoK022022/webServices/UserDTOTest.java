package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.builder.UserModelBuild;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDTOTest {
    private final ModelMapper modelMapper = new ModelMapper();
    private final UserModelBuild user = new UserModelBuild();

    @Test
    public void convertUserModelEntityToUserDto() {
        UserModel userModel = user
                .withName("Miguel")
                .withLastName("Bada")
                .withUsername("miguelbada")
                .withEmail("miguel@hotmail.com")
                .withAddress("Monroe 123456")
                .withPassword("123Aa*")
                .withCvuMercadoPago("1234567890123456789012")
                .withCriptoWallet("12345678")
                .built();

        UserDTO userDto = modelMapper.map(userModel, UserDTO.class);

        assertEquals(userDto.getName(), userModel.getName());
        assertEquals(userDto.getLastName(), userModel.getLastName());
        assertEquals(userDto.getUsername(), userModel.getUsername());
        assertEquals(userDto.getEmail(), userModel.getEmail());
        assertEquals(userDto.getAddress(), userModel.getAddress());
        assertEquals(userDto.getPassword(), userModel.getPassword());
        assertEquals(userDto.getCvuMercadoPago(), userModel.getCvuMercadoPago());
        assertEquals(userDto.getCriptoWallet(), userModel.getCriptoWallet());
    }

    @Test
    public void convertUserDtoToUserModelEntity() {
        UserDTO userDto = new UserDTO();
        userDto.setName("Juan");
        userDto.setLastName("Perez");
        userDto.setUsername("juancin");
        userDto.setAddress("Esmeralda 456778");
        userDto.setEmail("Juancin@gmail.com");
        userDto.setPassword("456aA*");
        userDto.setCvuMercadoPago("1234567890123456789012");
        userDto.setCriptoWallet("12345678");

        UserModel userModel = modelMapper.map(userDto, UserModel.class);

        assertEquals(userModel.getName(), userDto.getName());
        assertEquals(userModel.getLastName(), userDto.getLastName());
        assertEquals(userModel.getUsername(), userDto.getUsername());
        assertEquals(userModel.getEmail(), userDto.getEmail());
        assertEquals(userModel.getAddress(), userDto.getAddress());
        assertEquals(userModel.getPassword(), userDto.getPassword());
        assertEquals(userModel.getCvuMercadoPago(), userDto.getCvuMercadoPago());
        assertEquals(userModel.getCriptoWallet(), userDto.getCriptoWallet());
    }

}
