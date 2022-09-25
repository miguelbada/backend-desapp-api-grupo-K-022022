package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices;

import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.RoleModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.RoleType;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.UserModel;
import ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.builder.UserModelBuilder;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDTOTest {
    private final ModelMapper modelMapper = new ModelMapper();
    private final UserModelBuilder user = new UserModelBuilder();

    @Test
    public void convertUserModelEntityToUserModelEntity() {
        RoleModel roleUser = new RoleModel(RoleType.ROLE_USER);

        UserModel userModel = user
                .withName("Miguel")
                .withLastName("Bada")
                .withEmail("miguel@hotmail.com")
                .withAddress("Monroe 123456")
                .withPassword("123Aa*")
                .withCvuMercadoPago("1234567890123456789012")
                .withCriptoWallet("12345678")
                .built();

        UserDTO userDto = modelMapper.map(userModel, UserDTO.class);

        assertEquals(userDto.getName(), userModel.getName());
        assertEquals(userDto.getLastName(), userModel.getLastName());
        assertEquals(userDto.getEmail(), userModel.getEmail());
        assertEquals(userDto.getAddress(), userModel.getAddress());
        assertEquals(userDto.getPassword(), userModel.getPassword());
        assertEquals(userDto.getCvuMercadoPago(), userModel.getCvuMercadoPago());
        assertEquals(userDto.getCriptoWallet(), userModel.getCriptoWallet());
    }
}
