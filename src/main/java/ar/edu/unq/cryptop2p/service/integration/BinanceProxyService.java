package ar.edu.unq.cryptop2p.service.integration;

import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteListDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class BinanceProxyService {

	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Value("${integration.binance.api.url:NONE}")
	private String binanceApiURL;
	
	public CryptoCurrencyLastQuoteDto getCryptoCurrencyValue(String symbol) {
	CryptoCurrencyLastQuoteDto entity = restTemplate.getForObject(binanceApiURL + "ticker/price?symbol=" + symbol, CryptoCurrencyLastQuoteDto.class);
	return entity;
	}


	public List <CryptoCurrencyLastQuoteDto> getCryptoCurrenciesValues() {
		CryptoCurrencyLastQuoteListDto entity = restTemplate.getForObject(binanceApiURL + "ticker/price" , CryptoCurrencyLastQuoteListDto.class);
		assert entity != null;
		return entity.getCryptoCurrencyLastQuoteList();
	}

}
