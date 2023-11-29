package ar.edu.unq.cryptop2p.service.integration;

import ar.edu.unq.cryptop2p.model.dolar.Dollar;
import ar.edu.unq.cryptop2p.helpers.api.URLs;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.DollarProxyServerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static ar.edu.unq.cryptop2p.model.validators.Validator.response;

@Service
public class DollarProxyServer {
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${integration.dollar.api.url:NONE}")
    private String dolarApiURL;

    private URLs urls = new URLs();

    public Dollar updatePrice() throws DollarProxyServerException {
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "BEARER eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzAyNDMxMDMsInR5cGUiOiJleHRlcm5hbCIsInVzZXIiOiJmYXZhdGllcml0QGdtYWlsLmNvbSJ9.rR7zwyXXNTcELnX9QBs-Clrl04iwLdF5Fl1YnjpeJDurZXerR4tP4Vs3RdFrdJkD96gQ_zIkvYzh9SkFKGmxRg");
        HttpEntity<String> entity = new HttpEntity<>("",header);

        ResponseEntity<Dollar[]> response = restTemplate.exchange(urls.getDollarURL(), HttpMethod.GET, entity, Dollar[].class);
        Dollar[] dollars = response.getBody();

        if (dollars == null)
        {    var message = "Null from dollar api";
            response(message, HttpStatus.SERVICE_UNAVAILABLE);
            throw new DollarProxyServerException(message);
        }

        return dollars[dollars.length - 1];
    }
}
