package ar.edu.unq.cryptop2p.end2end;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.OptionCall;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.OptionPostDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.service.CryptoCurrencyService;
import ar.edu.unq.cryptop2p.service.OptionService;
import ar.edu.unq.cryptop2p.webservice.OptionController;
import ar.edu.unq.cryptop2p.webservice.UserCryptoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


//Se utilizan los datos precargados en la base de datos.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OptionControllerTests
{
    @Autowired
    private OptionService optionService;
    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;
    private static final String HTTP_LOCALHOST = "http://localhost:";
    @LocalServerPort
    private int port;
    @Autowired
    private OptionController controller;
    TestRestTemplate restTemplate;

    @BeforeEach
    void setUp()  {
        restTemplate = new TestRestTemplate();
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
    @DirtiesContext
    public void getOptionByID() throws NotFoundException, BadRequestException, PreconditionFailedException {
        String  uri = "/api/option/1";
        createOptionOnDB();

        var response = restTemplate.getForObject(HTTP_LOCALHOST + port + uri, OptionCall.class);

        assertThat(response).isInstanceOf(OptionCall.class);
        assertThat(response.getId()).isEqualTo(1);
    }

    public void createOptionOnDB() throws PreconditionFailedException, NotFoundException, BadRequestException {
        OptionPostDto optionPostDTO1 = new OptionPostDto(OptionType.OPTIONCALL, "BTC",30005D, 0.01f, 1L);
        optionService.post(optionPostDTO1);
    }

    @Test
    @DirtiesContext
    public void getOptionByIDCaseTheIDDoesNotExists() throws NotFoundException, BadRequestException, PreconditionFailedException {
        String  uri = "/api/option/111";
        createOptionOnDB();

        var response = restTemplate.getForObject(HTTP_LOCALHOST + port + uri, OptionCall.class);

        assertThat(response).isInstanceOf(OptionCall.class);
        assertThat(response.getId()).isEqualTo(1);
    }




@Test
@DirtiesContext
public void getAllOptions() throws NotFoundException, BadRequestException {
    String  uri = "/api/option/options";
    createTwoOptions();
    OptionCall[] optionsResponse;

    ResponseEntity<OptionCall[]> result = this.restTemplate.getForEntity(HTTP_LOCALHOST + port + uri, OptionCall[].class);
    optionsResponse = result.getBody();

    assertThat(optionsResponse.length).isEqualTo(2);
    assertThat(optionsResponse[0].getCryptoAmount()).isEqualTo(0.01f);
    assertThat(optionsResponse[1].getCryptoAmount()).isEqualTo(0.5f);
}

    public void createTwoOptions() throws NotFoundException, BadRequestException {
        OptionPostDto optionPostDTO1 = new OptionPostDto(OptionType.OPTIONCALL, "BTC",30005D, 0.01f, 1L);
        OptionPostDto optionPostDTO2 = new OptionPostDto(OptionType.OPTIONCALL, "BTC",30001D, 0.5f, 2L);
        optionService.post(optionPostDTO1);
        optionService.post(optionPostDTO2);
    }

    @Test
    @DirtiesContext
    public void getAllOptionsCaseOfZeroOptionOnDB() throws NotFoundException, BadRequestException {
        String  uri = "/api/option/options";
        OptionCall[] optionsResponse;

        ResponseEntity<OptionCall[]> result = this.restTemplate.getForEntity(HTTP_LOCALHOST + port + uri, OptionCall[].class);
        optionsResponse = result.getBody();

        assertThat(optionsResponse.length).isEqualTo(0);
    }
}
