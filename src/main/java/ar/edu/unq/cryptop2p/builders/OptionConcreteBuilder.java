package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.*;

public class OptionConcreteBuilder {
    private CryptoCurrency criptocurrency;
    private UserCrypto user;
    private float cryptoAmount = 0 ;
    private  double price = 0.00;
    private String address ="" ;
    private OptionType type ;

    public static OptionConcreteBuilder anyOption() {return new OptionConcreteBuilder(); }

    public OptionConcreteBuilder withAddress(String anAddress)
    {   address = anAddress;
        return this;
    }

    public OptionConcreteBuilder withCryptoAmount(float aCryptoAmount)
    {   cryptoAmount = aCryptoAmount;
        return this;
    }

    public OptionConcreteBuilder withPrice(double aPrice)
    {
        price = aPrice;
        return this;
    }

    public OptionConcreteBuilder withCryptoCurrency (CryptoCurrency aCryptoCurrency)
    {
        criptocurrency = aCryptoCurrency;
        return this;
    }

    public OptionConcreteBuilder withUser (UserCrypto anUser)
    {
        user =  anUser;
        return this;
    }

    public Option build ()  { return new OptionCall(criptocurrency,  price,  cryptoAmount, user);}

    public Option buildOptionCall ()  { return new OptionCall(criptocurrency,  price,  cryptoAmount, user);}

    public Option buildOptionPut ()  { return new OptionPut(criptocurrency,  price,  cryptoAmount, user);}

}
