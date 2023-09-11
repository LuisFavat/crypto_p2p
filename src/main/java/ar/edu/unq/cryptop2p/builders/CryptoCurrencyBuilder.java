package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.model.CryptoCurrency;

public class CryptoCurrencyBuilder {
    
    private String name = "empty name";
    private double price  = 0;

    public static CryptoCurrencyBuilder aCryto()
    {
        return new CryptoCurrencyBuilder();
    }

    public CryptoCurrencyBuilder withName(String aName)
    {
        name = aName;
        return this;
    }

    public CryptoCurrencyBuilder withPrice(double aPrice)
    {
        price = aPrice;
        return this;
    }

    public CryptoCurrency build()
    {
        return new CryptoCurrency(name, price);
    }
}
