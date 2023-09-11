package ar.edu.unq.cryptop2p.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptoCurrencyLastQuoteDTO {
    @JsonProperty("symbol")
    private String name;
    @JsonProperty("price")
    private String lastQuote;

    private String dateTime;
    public CryptoCurrencyLastQuoteDTO(String name, String lastQuote){
        this.name = name;
        this.lastQuote = lastQuote;
    }
}