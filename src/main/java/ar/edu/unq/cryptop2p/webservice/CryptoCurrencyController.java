package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyDto;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.service.CryptoCurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@Transactional
@RequestMapping("/api/crypto")
@EnableAutoConfiguration
public class CryptoCurrencyController {


    @Autowired
    private CryptoCurrencyService cryptoService;



    @Operation(summary = "Get All CryptoCurrencies latest quotes")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/quotes")
    public ResponseEntity<List<CryptoCurrencyLastQuoteDto>> getAllCryptoCurrenciesLatestQuotes(@RequestHeader(value = "Authorization") String  token) {
        List<CryptoCurrencyLastQuoteDto> cryptosQuotes = cryptoService.getCryptoCurrenciesLatestQuotes();
        return ResponseEntity.ok().body(cryptosQuotes);

    }


    @Operation(summary = "Get a CryptoCurrenccy latest quotes")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/quotes/{symbol}")
    public ResponseEntity<CryptoCurrencyLastQuoteDto> getCryptoCurrencieLatestQuotes( @RequestHeader(value = "Authorization") String  token,  @PathVariable("symbol") String symbol) throws NotFoundException {
        CryptoCurrencyLastQuoteDto cryptoQuotes = cryptoService.getCryptoCurrencyValue(symbol);
        return ResponseEntity.ok().body(cryptoQuotes);

    }


    @Operation(summary = "Get cryptocurrency quotes from the last 24 hours")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/lastquotes24hs/{name}")
    public ResponseEntity<List<CryptoCurrencyLastQuoteDto>> getCryptoCurrencyLastQuotes24hs(@RequestHeader(value = "Authorization") String  token,   @PathVariable("name") String name) throws BadRequestException {
        List<CryptoCurrencyLastQuoteDto> cryptoCurrencyLastQuotes24hs = cryptoService.getCryptoCurrencyLastQuotes24hs(name);
        return ResponseEntity.ok().body(cryptoCurrencyLastQuotes24hs);

    }


    @Operation(summary = "Create a CryptoCurrency")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/create")
    public ResponseEntity<CryptoCurrency> create(@RequestHeader(value = "Authorization") String  token,@RequestBody CryptoCurrencyDto cryptoDto) throws PreconditionFailedException {
        CryptoCurrency entity = cryptoService.create(cryptoDto.toModel());
        ResponseEntity.status(201);
        return ResponseEntity.ok().body(entity);
     }


    @Operation(summary = "Get all CryptoCurrencies")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/cryptos")
    public ResponseEntity<List<CryptoCurrency>> getAll(@RequestHeader(value = "Authorization") String  token) {
        List<CryptoCurrency> cryptos = cryptoService.getAll();
        return ResponseEntity.ok().body(cryptos);
    }

    @Operation(summary = "Find a CryptoCurrency by name")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/cryptos/{name}")
    public ResponseEntity<CryptoCurrency> findByName(@RequestHeader(value = "Authorization") String  token,@PathVariable("name") String name) throws NotFoundException {
        CryptoCurrency entity = cryptoService.findByName(name);
        ResponseEntity.status(200);
        return ResponseEntity.ok().body(entity);
       }
}



