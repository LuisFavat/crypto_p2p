package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.webservice.UserCryptoController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

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

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
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
