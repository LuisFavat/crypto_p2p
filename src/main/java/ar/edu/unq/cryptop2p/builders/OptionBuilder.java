package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.CryptoCurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class OptionBuilder {
    private CryptoCurrency criptocurrency;
    private UserCrypto user;
    private float cryptoAmount = 0 ;
    private  double price = 0.00;
    private OptionType tyoe ;


  // public static OptionBuilder anOption() {};


    public OptionBuilder withCryptoAmount(float aCryptoAmount)
    {   cryptoAmount = aCryptoAmount;
        return this;
    }

    public OptionBuilder withPrice(double aPrice)
    {
        price = aPrice;
        return this;
    }

    public OptionBuilder withCryptoCurrency (CryptoCurrency aCryptoCurrency)
    {
        criptocurrency = aCryptoCurrency;
        return this;
    }

    public OptionBuilder withUser (UserCrypto anUser)
    {
        user =  anUser;
        return this;
    }

    public abstract  Option build();


}
