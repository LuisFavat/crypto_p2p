package ar.edu.unq.cryptop2p.model.dto;

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
    public CryptoCurrencyLastQuoteDto(String name, String lastQuote){
        this.name = name;
        this.lastQuote = lastQuote;
    }
}