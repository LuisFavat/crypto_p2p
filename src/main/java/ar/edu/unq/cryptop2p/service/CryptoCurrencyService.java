package ar.edu.unq.cryptop2p.service;



import ar.edu.unq.cryptop2p.helpers.CryptoCurrencyEnum;
import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.persistence.CryptoCurrencyRepository;
import ar.edu.unq.cryptop2p.service.integration.BinanceProxyService;
import jakarta.annotation.PostConstruct;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static ar.edu.unq.cryptop2p.model.validators.Validator.*;

@EnableScheduling
@Service
public class CryptoCurrencyService {

    @Autowired
	CryptoCurrencyRepository  cryptoRepository ;

	@Autowired
	BinanceProxyService binanceProxyService;
/*
	@Transactional
	public List<CryptoCurrencyLastQuoteDto>  getCryptoCurrenciesLatestQuotes() {
        var cryptoNames = CryptoCurrencyEnum.values();
		var cryptosForBinance  = binanceProxyService.getCryptoCurrenciesValues();
		var cryptos =   cryptosForBinance.stream().filter( (crypto) ->  Arrays.stream(cryptoNames).toList().contains(crypto.getName() )).toList();
		return cryptos;
	}
*/

	@Cacheable(cacheNames = "cryptoQuotes")
	public List<CryptoCurrencyLastQuoteDto>  getCryptoCurrenciesLatestQuotes() {
		var cryptos = cryptoRepository.findAll();
		System.out.println("On data base");
		return toCryptoCurrencyLastQuoteDto(cryptos);
	}


	private List<CryptoCurrencyLastQuoteDto> toCryptoCurrencyLastQuoteDto(List<CryptoCurrency> list)
	{
		var result = new ArrayList<CryptoCurrencyLastQuoteDto> ();
		for (CryptoCurrency crypto : list)
		{
			result.add(new CryptoCurrencyLastQuoteDto(crypto.getName(), crypto.getPrice().toString() ,crypto.getDateTime()));
		}
		return result;
	}



	@PostConstruct
	@Scheduled(fixedDelay = 600000)//600.000 milisec = 10 min
	public void getLastQuoteFromBinance()
	{
		var cryptoNames = Arrays.stream(CryptoCurrencyEnum.values()).toList().toString();
		var cryptosForBinance  = binanceProxyService.getCryptoCurrenciesValues();
		var cryptos =   cryptosForBinance.stream().toList();
		var result = new ArrayList<CryptoCurrencyLastQuoteDto>();
		for (CryptoCurrencyLastQuoteDto crypto : cryptos)
		{
			if(cryptoNames.contains(crypto.getName()))
			{
				crypto.setDateTime(CurrentDateTime.getNewDateString());
				result.add(crypto);
			}
		}

		//cryptoRepository.saveAll(toListModel(result));
		saveAll(toListModel(result));

		System.out.println("Persistencia fix time");
	}

	@CachePut(cacheNames = "cryptoQuote")
	private void saveAll(List<CryptoCurrency> cryptoQuotes)
	{
		System.out.println("on database");
		cryptoRepository.saveAll(cryptoQuotes);
	}

	private List<CryptoCurrency> toListModel(List<CryptoCurrencyLastQuoteDto> list)
	{
			var cryptosModel = new ArrayList<CryptoCurrency>();

			for(CryptoCurrencyLastQuoteDto dto : list)
			{
				cryptosModel.add(dto.ToModelObject());
			}

			return cryptosModel;
	}

	/*
	@Transactional
    public CryptoCurrencyLastQuoteDto getCryptoCurrencyValue(String symbol) {
		CryptoCurrencyLastQuoteDto entity = binanceProxyService.getCryptoCurrencyValue(symbol);
		if (entity != null) {
			entity.setDateTime(CurrentDateTime.getNewDateString());
		}
		return entity;
	}
*/


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Cacheable(cacheNames = "quotes", key="#symbol")
	public CryptoCurrencyLastQuoteDto getCryptoCurrencyValue(String symbol) throws NotFoundException {
		CryptoCurrencyLastQuoteDto entity = binanceProxyService.getCryptoCurrencyValue(symbol);
		if (entity == null ) {
			String message = " CruyptoCurrency name is does not exist";
			response(message, HttpStatus.NOT_FOUND);
			throw new NotFoundException(message);
		}
		entity.setDateTime(CurrentDateTime.getNewDateString());
		System.out.println("on database");
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

	@Transactional
	public List<CryptoCurrencyLastQuoteDto>  getCryptoCurrencyLastQuotes24hs(String name) throws NotFoundException {
		CryptoCurrency  cryptoCurrency = findByName(name);
		return binanceProxyService.getCryptoCurrencyLastQuotes24hs(cryptoCurrency);
	}

}
