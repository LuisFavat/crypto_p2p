package ar.edu.unq.cryptop2p.model.dolar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Date;


//@Getter
//@Setter
@Data
public class Dollar
{
    @JsonProperty("d")
    Date lastUpdate;
    @JsonProperty("v")
    float price;

    public Dollar(Date lastUpdate, float price)
    {
        this.lastUpdate = lastUpdate;
        this.price = price;
    }

    public Dollar()
    {

    }
}
