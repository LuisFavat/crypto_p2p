package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyDto;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.service.CryptoCurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import static  ar.edu.unq.cryptop2p.model.validators.Validator.*;

import java.util.HashMap;
import java.util.List;


@RestController
@Transactional
@RequestMapping("/api/crypto")
@EnableAutoConfiguration
public class CryptoCurrencyController {


    @Autowired
    private CryptoCurrencyService cryptoService;


    @Operation(summary = "Get All CryptoCurrencies latest quotes")
    @GetMapping("/quotes")
    public ResponseEntity<List<CryptoCurrencyLastQuoteDto>>getAllCryptoCurrenciesLatestQuotes(){
        List<CryptoCurrencyLastQuoteDto> cryptosQuotes = cryptoService.getCryptoCurrenciesLatestQuotes();
        return ResponseEntity.ok().body(cryptosQuotes);

    }


    @Operation(summary = "Get a CryptoCurrenccy latest quotes")
    @GetMapping("/quotes/{symbol}")
    public ResponseEntity<CryptoCurrencyLastQuoteDto>getCryptoCurrencieLatestQuotes(@PathVariable("symbol" )String symbol){
        ResponseEntity response;
        try {
            CryptoCurrencyLastQuoteDto cryptoQuotes = cryptoService.getCryptoCurrencyValue(symbol);
            response = ResponseEntity.ok().body(cryptoQuotes);
        } catch (Exception e) {
            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response;
    }




    @Operation(summary = "Get cryptocurrency quotes from the last 24 hours")
    @GetMapping("/lastquotes24hs/{name}")
    public ResponseEntity<List<CryptoCurrencyLastQuoteDto>>getCryptoCurrencyLastQuotes24hs(@PathVariable("name")String name) {
        ResponseEntity response;
        try {
            List<CryptoCurrencyLastQuoteDto> cryptoCurrencyLastQuotes24hs = cryptoService.getCryptoCurrencyLastQuotes24hs(name);
            response = ResponseEntity.ok().body(cryptoCurrencyLastQuotes24hs);
        } catch (Exception e) {
            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response;

    }




    @Operation(summary = "Create a CryptoCurrency")
    @PostMapping("/create")
    public ResponseEntity<CryptoCurrency>create(@RequestBody CryptoCurrencyDto cryptoDto ){
        ResponseEntity response;
        try {
            CryptoCurrency entity =  cryptoService.create(cryptoDto.toModel());
            ResponseEntity.status(201);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response ;

    }


    @Operation(summary = "Get all CryptoCurrencies")
    @GetMapping("/cryptos")
    public ResponseEntity <List<CryptoCurrency>>getAll(){
        List<CryptoCurrency> cryptos = cryptoService.getAll();
        return ResponseEntity.ok().body(cryptos);
    }

    @Operation(summary = "Find a CryptoCurrency by name")
    @GetMapping("/cryptos/{name}")
    public ResponseEntity <CryptoCurrency>findByName(@PathVariable("name") String name) throws NotFoundException {
        ResponseEntity response;
        try {
            CryptoCurrency entity = cryptoService.findByName(name);
            ResponseEntity.status(200);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            HashMap result = getResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response;
    }
}



