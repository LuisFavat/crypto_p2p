package ar.edu.unq.cryptop2p.webservice;

import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.service.CryptoCurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @Operation(summary = "Get a CryptoCurrencie latest quotes")
    @GetMapping("/quotes/{symbol}")
    public ResponseEntity<CryptoCurrencyLastQuoteDto>getCryptoCurrencieLatestQuotes(@PathVariable("symbol" )String symbol){
       CryptoCurrencyLastQuoteDto cryptoQuotes = cryptoService.getCryptoCurrencyValue(symbol);
        return ResponseEntity.ok().body(cryptoQuotes);

    }

}
