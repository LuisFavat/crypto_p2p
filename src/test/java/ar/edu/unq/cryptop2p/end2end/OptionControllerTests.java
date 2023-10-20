package ar.edu.unq.cryptop2p.end2end;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.OptionCall;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.webservice.OptionController;
import ar.edu.unq.cryptop2p.webservice.UserCryptoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


//Se utilizan los datos precargados en la base de datos.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OptionControllerTests
{
    private static final String HTTP_LOCALHOST = "http://localhost:";
    @LocalServerPort
    private int port;
    @Autowired
    private OptionController controller;
    RestTemplate restTemplate;

    @BeforeEach
    void setUp()  {
        restTemplate = new RestTemplate();
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @DirtiesContext
    public void registerAOption() throws Exception {
        String uri = "/api/option/post";
        OptionPostDto optionPostDTO = new OptionPostDto(OptionType.OPTIONCALL, "BTC",30005D, 0.01f, 1L);

        var response = restTemplate.postForObject(HTTP_LOCALHOST + port + uri, optionPostDTO, OptionCall.class);

        assertThat(response).isInstanceOf(OptionCall.class);
        assertThat(response.getOperation()).isEqualTo(optionPostDTO.getOperation());
    }


    @Test
    public void getOptionByID()
    {
        String  uri = "/api/option/1";

        var response = restTemplate.getForObject(HTTP_LOCALHOST + port + uri, OptionCall.class);

        assertThat(response).isInstanceOf(OptionCall.class);
        assertThat(response.getId()).isEqualTo(1);
    }

//    @Test
//    public void getAllOptionByID()
//    {
//        String  uri = "/api/option/options";
//
//        var response = restTemplate.getForObject(HTTP_LOCALHOST + port + uri, OptionCall.class);
//
//        assertThat(response).isInstanceOf(OptionCall.class);
//        assertThat(response.getId()).isEqualTo(1);
//    }
}
