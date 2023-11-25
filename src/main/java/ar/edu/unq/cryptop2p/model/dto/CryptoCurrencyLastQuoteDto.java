package ar.edu.unq.cryptop2p.model.dto;

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

    //Este campo al ser static se comporto similar a si fuera transcient
    //private static final long serialVersion = 1L;
    /*
    public CryptoCurrencyLastQuoteDto(String name, String lastQuote, String dateTime){
        this.name = name;
        this.lastQuote = lastQuote;
        this.dateTime = dateTime;
    }

     */

    public CryptoCurrency ToModelObject()
    {
        return new CryptoCurrency(this.getName(),  Double.parseDouble(this.getLastQuote()), this.getDateTime());
    }
}