package ar.edu.unq.cryptop2p.model.dto;

import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import lombok.Data;
import java.io.Serializable;

@Data
public class CryptoCurrencyDto implements Serializable {
    private final String name;
    private final Double price;
    private String dateTime;

    public CryptoCurrency toModel() {
        dateTime = CurrentDateTime.getNewDateString();
        var crypto = new CryptoCurrency (name,price);
         crypto.setDateTime(CurrentDateTime.getNewDateString());
        return crypto;
    }


}
