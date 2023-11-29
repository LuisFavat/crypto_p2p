package ar.edu.unq.cryptop2p.service.integration;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.dto.CryptoCurrencyLastQuoteDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static ar.edu.unq.cryptop2p.helpers.CurrentDateTime.*;

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
		ResponseEntity<CryptoCurrencyLastQuoteDto[]> entity = restTemplate.getForEntity(binanceApiURL + "ticker/price"  , CryptoCurrencyLastQuoteDto[].class);
		return Arrays.asList(Objects.requireNonNull(entity.getBody()));
	}


	public List<CryptoCurrencyLastQuoteDto> getCryptoCurrencyLastQuotes24hs(String name) {

		String url = binanceApiURL + "klines?symbol=" + name +
				"&interval=1h&startTime=" + getCurrentTimeMinusOneDayInMilliseconds() +
				"&endTime=" + getCurrentTimeInMilliseconds();

		ResponseEntity<List[]> responseList =
				restTemplate.getForEntity(url, List[].class);

		return Arrays.stream(Objects.requireNonNull(responseList.getBody())).map(
				obj -> new CryptoCurrencyLastQuoteDto(name,
						obj.get(4) + "",
						longToDate((long) obj.get(0)))).collect(Collectors.toList());
	}

}
