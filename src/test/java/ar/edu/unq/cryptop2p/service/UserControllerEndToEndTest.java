package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.webservice.UserCryptoController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.reactive.function.BodyInserter;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerEndToEndTest {
    private static final String HTTP_LOCALHOST = "http://localhost:";
    @LocalServerPort
    private int port;
    @Autowired
    private UserCryptoController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private WebTestClient webClient;

//    @Autowired
//    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

//    @Test
//    public void register() throws Exception {
//        String uri = "/api/user/register";
//
//        String body = "{" +
//                "\"name\":\"Felipe\"," +
//                "\"surname\":\"Mujica\"," +
//                "\"address\":\"dir1132123123\"," +
//                "\"password\":\"Very_Secret!\"," +
//                "\"email\":\"felipemujica@gmail.com\"," +
//                "\"cvu\":\"1234567890123456789012\"," +
//                "\"cryptoAddress\":\"12345678\"," +
//                "}";

//        mockMvc.perform(MockMvcRequestBuilders.post(uri)
//                    .content(body)
//                    .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers
//                        .content()
//                        .contentType(MediaType.APPLICATION_JSON));


//        UserRegisterDto bodyDTO = new UserRegisterDto("Felipe", "Apellido", "direccion 123", "UnaPass!", "felipe@gmail.com", "1234567890123456789012", "12345678");
//        webClient.post().uri(uri);
//        var result = this.restTemplate.getForObject(HTTP_LOCALHOST + port + uri, String.class);
//        assertThat(result).isEqualTo();
//    }


    @Test
    public void getAllUsers()
    {
        String uri = "/api/user/users";
        webClient.get().uri(uri);
        var result = this.restTemplate.getForObject(HTTP_LOCALHOST + port + uri, String.class);
        System.out.println("HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        System.out.println(result);
        assertThat(result).isEqualTo("[{" +
                        "\"id\":1," +
                        "\"name\":\"Ale\"," +
                        "\"surname\":\"Fariña\"," +
                        "\"address\":\"dir1132123123\"," +
                        "\"password\":\"Very_Secret!\"," +
                        "\"email\":\"ale@gmail.com\"," +
                        "\"cvu\":\"1234567890123456789012\"," +
                        "\"cryptoAddress\":\"12345678\"," +
                        "\"numberOfOperation\":0," +
                        "\"scores\":0," +
                        "\"reputation\":0" +
                        "}," +
                        "{"  +
                        "\"id\":2," +
                        "\"name\":\"Luis\"," +
                        "\"surname\":\"Favatier\"," +
                        "\"address\":\"dir1132123140\"," +
                        "\"password\":\"Extremly_Secret!\"," +
                        "\"email\":\"luis@gmail.com\"," +
                        "\"cvu\":\"1234567890123456789015\"," +
                        "\"cryptoAddress\":\"12345679\"," +
                        "\"numberOfOperation\":0," +
                        "\"scores\":0," +
                        "\"reputation\":0" +
                        "}]");
    }



    @Test
    public void getUserByEmail()
    {
        String uri = "/api/user/email/ale@gmail.com";
        webClient.get().uri(uri);
        var result = this.restTemplate.getForObject(HTTP_LOCALHOST + port + uri, String.class);
        assertThat(result).isEqualTo("{" +
                "\"id\":1," +
                "\"name\":\"Ale\"," +
                "\"surname\":\"Fariña\"," +
                "\"address\":\"dir1132123123\"," +
                "\"password\":\"Very_Secret!\"," +
                "\"email\":\"ale@gmail.com\"," +
                "\"cvu\":\"1234567890123456789012\"," +
                "\"cryptoAddress\":\"12345678\"," +
                "\"numberOfOperation\":0," +
                "\"scores\":0," +
                "\"reputation\":0}");
    }
}
