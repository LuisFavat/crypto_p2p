package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.helpers.api.URLs;
import ar.edu.unq.cryptop2p.model.dolar.Dollar;
import ar.edu.unq.cryptop2p.model.exceptions.DollarProxyServerException;
import ar.edu.unq.cryptop2p.service.integration.DollarProxyServer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.UriAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.time.LocalDate;


@ExtendWith(MockitoExtension.class)
public class DolarProxyServerTests
{

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private DollarProxyServer dollarServer;

    @Test
    public void updatePrice() throws DollarProxyServerException
    {
        Dollar dolar1 = new Dollar();
        Dollar dolar2 = new Dollar(new Date(2023,1,1), 500);
        Dollar[] dollars = {dolar1, dolar2};
        ResponseEntity<Dollar[]> response = new ResponseEntity<>(dollars, HttpStatusCode.valueOf(200));
        var urls = new URLs();
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "BEARER eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzAyNDMxMDMsInR5cGUiOiJleHRlcm5hbCIsInVzZXIiOiJmYXZhdGllcml0QGdtYWlsLmNvbSJ9.rR7zwyXXNTcELnX9QBs-Clrl04iwLdF5Fl1YnjpeJDurZXerR4tP4Vs3RdFrdJkD96gQ_zIkvYzh9SkFKGmxRg");
        HttpEntity<String> entity = new HttpEntity<>("",header);
        Mockito.when(restTemplate.exchange(urls.getDollarURL(), HttpMethod.GET, entity, Dollar[].class))
                .thenReturn(new ResponseEntity<>(dollars, HttpStatus.OK));


        Dollar dolar = dollarServer.updatePrice();

        Assertions.assertEquals(dolar2, dolar);
    }

}
