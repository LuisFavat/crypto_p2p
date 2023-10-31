package ar.edu.unq.cryptop2p.service;


import ar.edu.unq.cryptop2p.helpers.CryptoCurrencyEnum;
import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.persistence.CryptoCurrencyRepository;
import ar.edu.unq.cryptop2p.service.integration.BinanceProxyService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static ar.edu.unq.cryptop2p.model.validators.Validator.*;

@Service
public class CryptoCurrencyService {

    @Autowired
	CryptoCurrencyRepository  cryptoRepository ;

	@Autowired
	BinanceProxyService binanceProxyService;


	@Transactional
	public List<CryptoCurrencyLastQuoteDto>  getCryptoCurrenciesLatestQuotes() {
        var cryptoNames = CryptoCurrencyEnum.values();
		var cryptosForBinance  = binanceProxyService.getCryptoCurrenciesValues();
		var cryptos =   cryptosForBinance.stream().filter( (crypto) ->  Arrays.stream(cryptoNames).toList().contains(crypto.getName() )).toList();
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
	public CryptoCurrency create(@NotNull CryptoCurrency crypto) throws PreconditionFailedException {
		if (existByName(crypto.getName())){
			String message = "Crypto: "+ crypto.getName() + "already exists, please try with another name";
			response(message, HttpStatus.PRECONDITION_FAILED);
			throw new PreconditionFailedException(message);
		}
		return cryptoRepository.save(crypto);
	}

	private @NotNull Boolean existByName(String name) {return cryptoRepository.findByName(name).isPresent(); }


	@Transactional
	public List<CryptoCurrency> getAll(){
		return cryptoRepository.findAll();
	}

	@Transactional
	public CryptoCurrency findByName(String name) throws NotFoundException {
		var  crypto = cryptoRepository.findByName(name);
		if (crypto.isEmpty()) {
			String message = MessageFormat.format(" CruyptoCurrency with name: {0} not found.", name);
			response(message, HttpStatus.NOT_FOUND);
			throw new NotFoundException(message);
		}
		return crypto.get();

	}
}
