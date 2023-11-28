package ar.edu.unq.cryptop2p.end2end;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.webservice.UserCryptoController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTests {
    /*
    private static final String HTTP_LOCALHOST = "http://localhost:";

    @LocalServerPort
    private int port;

    @Autowired
    private UserCryptoController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    //Estos dos usuarios (UserCrypto) se cargan al inicializar el programa de forma automatica
    UserCrypto user1 = new UserCrypto(1L,"Ale", "Fariña", "dir1132123123", "Very_Secret!", "ale@gmail.com","1234567890123456789012","12345678");
    UserCrypto user2 = new UserCrypto(2L,"Luis", "Favatier", "dir1132123140", "Extremly_Secret!", "luis@gmail.com","1234567890123456789015","12345679");

    UserRegisterDto aUserRegisterDTO = new UserRegisterDto("Felipe", "Apellido", "direccion 123", "UnaPass!", "felipe@gmail.com", "1234567890123456789012", "12345678");



    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @DirtiesContext
    public void register() throws Exception {
        String uri = "/api/user/register";
        UserCrypto user = aUserRegisterDTO.toModel();

        var userResponse = restTemplate.postForObject(HTTP_LOCALHOST + port + uri, aUserRegisterDTO, UserCrypto.class);

        assertThat(userResponse).isEqualTo(user);
    }

    @Test
    @DirtiesContext
    public void registerCaseBadRequest() throws Exception {
        String uri = "/api/user/register";
        UserRegisterDto registerDto = new UserRegisterDto("", "", "", "", "", "", "");
        UserCrypto user = aUserRegisterDTO.toModel();

        var response = restTemplate.postForEntity(HTTP_LOCALHOST + port + uri, registerDto, String.class);

        assertThat(response.getStatusCode().value()).isEqualTo(400);
    }


    @Test
    public void getAllUsers()
    {
        String uri = "/api/user/users";
        UserCrypto[] usersExpected = expectedUsers();
        UserCrypto[] usersResponse;

        ResponseEntity<UserCrypto[]> result = this.restTemplate.getForEntity(HTTP_LOCALHOST + port + uri, UserCrypto[].class);
        usersResponse = result.getBody();

        assertThat(usersResponse).isEqualTo(usersExpected);
    }

    public UserCrypto[] expectedUsers()
    {
        UserCrypto[] usersExpected = new UserCrypto[2];
        usersExpected[0] = user1;
        usersExpected[1] = user2;
        return  usersExpected;
    }


    @Test
    public void getUserByEmail()
    {
        String uri = "/api/user/email/ale@gmail.com";

        var result = restTemplate.getForObject(HTTP_LOCALHOST + port + uri, UserCrypto.class);

        assertThat(result).isEqualTo(user1);

    }

    
    @Test
    public void getUserByID() {
        String uri = "/api/user/1";

        var result = restTemplate.getForObject(HTTP_LOCALHOST + port + uri, UserCrypto.class);

        assertThat(result).isEqualTo(user1);

    }
*/


}
