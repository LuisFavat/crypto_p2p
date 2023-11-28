package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyDto;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.service.CryptoCurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
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
    //@Cacheable(cacheNames = CacheConfig.LAST_QUOTE_CACHE, unless = "#result == null")//no cachea si es null
    public ResponseEntity<List<CryptoCurrencyLastQuoteDto>>getAllCryptoCurrenciesLatestQuotes(){
//        List<CryptoCurrencyLastQuoteDto> cryptosQuotes = cryptoService.getCryptoCurrenciesLatestQuotes();
//        System.out.println("pepito01");
//        return ResponseEntity.ok().body(cryptosQuotes);
        return ResponseEntity.ok().body(cryptoService.getCryptoCurrenciesLatestQuotes());
    }




    @Operation(summary = "Get a CryptoCurrenccy latest quotes")
    //@Cacheable(cacheNames = CacheConfig.LAST_QUOTE_CACHE, unless = "#result == null")
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



