package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.helpers.CryptoCurrencyEnum;
import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.dolar.Dollar;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.persistence.CryptoCurrencyRepository;
import ar.edu.unq.cryptop2p.service.integration.BinanceProxyService;
import ar.edu.unq.cryptop2p.service.integration.DollarProxyServer;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import static  ar.edu.unq.cryptop2p.helpers.CurrentDateTime.*;
import static ar.edu.unq.cryptop2p.model.validators.Validator.*;

@Service
public class CryptoCurrencyService {

	@Autowired
	CryptoCurrencyRepository cryptoRepository;

	@Autowired
	BinanceProxyService binanceProxyService;

	@Autowired
	DollarProxyServer dollarProxyService;


	@Transactional
	public List<CryptoCurrencyLastQuoteDto> getCryptoCurrenciesLatestQuotes() {
		var cryptoNames = Arrays.stream(CryptoCurrencyEnum.values()).map(Enum::toString).toList();
		var cryptosForBinance = binanceProxyService.getCryptoCurrenciesValues();
		var cryptos = cryptosForBinance.stream().filter((crypto) -> cryptoNames.contains(crypto.getName()));
		return cryptos.toList().stream().map(this::agregateDateTime).toList();
	}


	public CryptoCurrencyLastQuoteDto agregateDateTime(CryptoCurrencyLastQuoteDto crypto) {
		crypto.setDateTime(getNewDateString());
		return crypto;
	}


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public CryptoCurrencyLastQuoteDto getCryptoCurrencyValue(String symbol) throws NotFoundException {
		CryptoCurrencyLastQuoteDto entity = binanceProxyService.getCryptoCurrencyValue(symbol);
		if (entity == null) {
			String message = " CruyptoCurrency name is does not exist";
			response(message, HttpStatus.NOT_FOUND);
			throw new NotFoundException(message);
		}
		entity.setDateTime(CurrentDateTime.getNewDateString());
		return entity;
	}


	@Transactional
	public CryptoCurrency create(@NotNull CryptoCurrency crypto) throws PreconditionFailedException {
		if (existByName(crypto.getName())) {
			String message = "Crypto: " + crypto.getName() + "already exists, please try with another name";
			response(message, HttpStatus.PRECONDITION_FAILED);
			throw new PreconditionFailedException(message);
		}
		return cryptoRepository.save(crypto);
	}

	private @NotNull Boolean existByName(String name) {
		return cryptoRepository.findByName(name).isPresent();
	}


	@Transactional
	public List<CryptoCurrency> getAll() {
		return cryptoRepository.findAll();
	}

	@Transactional
	public CryptoCurrency findByName(String name) throws NotFoundException {
		var crypto = cryptoRepository.findByName(name);
		if (crypto.isEmpty()) {
			String message = MessageFormat.format(" CruyptoCurrency with name: {0} not found.", name);
			response(message, HttpStatus.NOT_FOUND);
			throw new NotFoundException(message);
		}
		return crypto.get();
	}

	@Transactional
	public List<CryptoCurrencyLastQuoteDto> getCryptoCurrencyLastQuotes24hs(String name)  throws BadRequestException {
	    var cryptoCurrenciesLast24hs =  binanceProxyService.getCryptoCurrencyLastQuotes24hs(name);
		if (cryptoCurrenciesLast24hs.isEmpty()) {
			String message = "Can not get CryptoCurrencies Last quotes 24 hs";
			response(message, HttpStatus.BAD_REQUEST);
			throw new BadRequestException(message);
		}
		return cryptoCurrenciesLast24hs;
	}

	@Transactional
	public Dollar updatePrice() {
		try {
			return  dollarProxyService.updatePrice();
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		return null;
	}
}