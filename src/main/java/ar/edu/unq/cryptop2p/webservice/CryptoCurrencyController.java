package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyDto;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
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
    public ResponseEntity<List<CryptoCurrencyLastQuoteDto>> getAllCryptoCurrenciesLatestQuotes(){
        return ResponseEntity.ok().body(cryptoService.getCryptoCurrenciesLatestQuotes());
    }

    @Operation(summary = "Get a CryptoCurrenccy latest quotes")
    @GetMapping("/quotes/{symbol}")
    public ResponseEntity<CryptoCurrencyLastQuoteDto> getCryptoCurrencieLatestQuotes(@PathVariable("symbol") String symbol) throws NotFoundException {
        CryptoCurrencyLastQuoteDto cryptoQuotes = cryptoService.getCryptoCurrencyValue(symbol);
        return ResponseEntity.ok().body(cryptoQuotes);

    }


    @Operation(summary = "Get cryptocurrency quotes from the last 24 hours")
    @GetMapping("/lastquotes24hs/{name}")
    public ResponseEntity<List<CryptoCurrencyLastQuoteDto>> getCryptoCurrencyLastQuotes24hs(@PathVariable("name") String name) throws BadRequestException {
        List<CryptoCurrencyLastQuoteDto> cryptoCurrencyLastQuotes24hs = cryptoService.getCryptoCurrencyLastQuotes24hs(name);
        return ResponseEntity.ok().body(cryptoCurrencyLastQuotes24hs);

    }


    @Operation(summary = "Create a CryptoCurrency")
    @PostMapping("/create")
    public ResponseEntity<CryptoCurrency> create(@RequestBody CryptoCurrencyDto cryptoDto) throws PreconditionFailedException {
        CryptoCurrency entity = cryptoService.create(cryptoDto.toModel());
        ResponseEntity.status(201);
        return ResponseEntity.ok().body(entity);
     }


    @Operation(summary = "Get all CryptoCurrencies")
    @GetMapping("/cryptos")
    public ResponseEntity<List<CryptoCurrency>> getAll() {
        List<CryptoCurrency> cryptos = cryptoService.getAll();
        return ResponseEntity.ok().body(cryptos);
    }

    @Operation(summary = "Find a CryptoCurrency by name")
    @GetMapping("/cryptos/{name}")
    public ResponseEntity<CryptoCurrency> findByName(@PathVariable("name") String name) throws NotFoundException {
        CryptoCurrency entity = cryptoService.findByName(name);
        ResponseEntity.status(200);
        return ResponseEntity.ok().body(entity);
       }
}



