package ar.edu.unq.cryptop2p.service;


import ar.edu.unq.cryptop2p.helpers.CryptoCurrencyEnum;
import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyDto;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.UserNameExistsException;
import ar.edu.unq.cryptop2p.persistence.CryptoCurrencyRepository;
import ar.edu.unq.cryptop2p.service.integration.BinanceProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import static ar.edu.unq.cryptop2p.model.validators.Validator.badRequestResponse;
import static ar.edu.unq.cryptop2p.model.validators.Validator.notFoundResponse;

@Service
public class CryptoCurrencyService {
    @Autowired
	CryptoCurrencyRepository cryptoRepository;

	@Autowired
	BinanceProxyService binanceProxyService;

	@Transactional
	public List<CryptoCurrencyLastQuoteDto>  getCryptoCurrenciesLatestQuotes() {

		 var cryptoNames = CryptoCurrencyEnum.values();
		 var cryptos = Arrays.stream(cryptoNames).map((crypto -> getCryptoCurrencyValue(crypto.name() ))).toList();
	     return cryptos;
	}

	@Transactional
    public CryptoCurrencyLastQuoteDto getCryptoCurrencyValue(String symbol) {
		CryptoCurrencyLastQuoteDto entity = binanceProxyService.getCryptoCurrencyValue(symbol);
		if (entity != null) {
			entity.setDateTime(CurrentDateTime.getNewDateString());
		}
		return entity;
	}

	@Transactional
	public CryptoCurrency create(CryptoCurrency crypto) throws UserNameExistsException {
		if (existByName(crypto.getName())){
			String message = "Crypto: "+ crypto.getName() + "already exists, please try with another name";
			badRequestResponse(message);
			throw new UserNameExistsException(message);
		}
		return cryptoRepository.save(crypto);
	}

	private Boolean existByName(String name) {return cryptoRepository.findByName(name).isPresent(); }


	@Transactional
	public List<CryptoCurrency> getAll(){
		return cryptoRepository.findAll();
	}

	@Transactional
	public CryptoCurrency findByName(String name) throws NotFoundException {
		var  crypto = cryptoRepository.findByName(name);
		if (crypto.isEmpty()) {
			String message = MessageFormat.format(" CruyptoCurrency with name: {0} not found.", name);
			notFoundResponse(message);
			throw new NotFoundException(message);
		}
		return crypto.get();

	}
}
