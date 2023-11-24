package ar.edu.unq.cryptop2p.model.dto;

import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CryptoCurrencyLastQuoteDto implements Serializable {
    @JsonProperty("symbol")
    private String name;
    @JsonProperty("price")
    private String lastQuote;

    private String dateTime;
    public CryptoCurrencyLastQuoteDto(String name, String lastQuote){
        this.name = name;
        this.lastQuote = lastQuote;
    }



}