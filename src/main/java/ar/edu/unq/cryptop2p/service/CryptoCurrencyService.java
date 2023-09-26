package ar.edu.unq.cryptop2p.service;


import ar.edu.unq.cryptop2p.helpers.CryptoCurrencyEnum;
import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.persistence.CryptoCurrencyRepository;
import ar.edu.unq.cryptop2p.service.integration.BinanceProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CryptoCurrencyService {
    @Autowired
	CryptoCurrencyRepository cryptoRepository;

	@Autowired
	BinanceProxyService binanceProxyService;


	public List<CryptoCurrencyLastQuoteDto>  getCryptoCurrenciesLatestQuotes() {

		 var cryptoNames = CryptoCurrencyEnum.values();
		 var cryptos = Arrays.stream(cryptoNames).map((crypto -> getCryptoCurrencyValue(crypto.name() ))).toList();
	     return cryptos;
	}
    
    

    public CryptoCurrencyLastQuoteDto getCryptoCurrencyValue(String symbol) {
		CryptoCurrencyLastQuoteDto entity = binanceProxyService.getCryptoCurrencyValue(symbol);
		if (entity != null) {
			entity.setDateTime(CurrentDateTime.getNewDateString());
		}
		return entity;
	}
}
