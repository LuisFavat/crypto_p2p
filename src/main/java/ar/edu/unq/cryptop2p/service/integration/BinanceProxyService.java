package ar.edu.unq.cryptop2p.service.integration;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceProxyService {

	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Value("${integration.binance.api.url:NONE}")
	private String binanceApiURL;
	
	public CryptoCurrencyLastQuoteDTO getCryptoCurrencyValue(String symbol) {
	CryptoCurrencyLastQuoteDTO entity = restTemplate.getForObject(binanceApiURL + "ticker/price?symbol=" + symbol, CryptoCurrencyLastQuoteDTO.class);
	return entity;
	}


}
