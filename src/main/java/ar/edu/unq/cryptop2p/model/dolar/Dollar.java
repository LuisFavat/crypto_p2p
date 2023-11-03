package ar.edu.unq.cryptop2p.model.dolar;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.time.LocalDate;


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