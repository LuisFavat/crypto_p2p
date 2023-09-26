package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.UserCrypto;
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

import java.util.HashMap;
import java.util.List;

import static ar.edu.unq.cryptop2p.model.validators.Validator.getBadRequestResponse;
import static ar.edu.unq.cryptop2p.model.validators.Validator.getNotFoundResponse;

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
       CryptoCurrencyLastQuoteDto cryptoQuotes = cryptoService.getCryptoCurrencyValue(symbol);
        return ResponseEntity.ok().body(cryptoQuotes);

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
            HashMap result = getBadRequestResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response ;

    }


    @Operation(summary = "Get all CryptoCurrencies")
    @GetMapping("/cryptos")
    public ResponseEntity <List<CryptoCurrency>>getAll(){
        List<CryptoCurrency> cryptos = cryptoService.getAll();
        ResponseEntity.status(201);
        return ResponseEntity.ok().body(cryptos);
    }

    @Operation(summary = "Find a CryptoCurrency by name")
    @GetMapping("/cryptos/{name}")
    public ResponseEntity <CryptoCurrency>findByName(@PathVariable("name") String name) throws NotFoundException {
        ResponseEntity response;
        try {
            CryptoCurrency entity = cryptoService.findByName(name);
            ResponseEntity.status(201);
            response = ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            HashMap result = getNotFoundResponse();
            response = ResponseEntity.ok().body(result);
        }
        return response;
    }
  }



