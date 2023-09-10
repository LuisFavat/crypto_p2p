package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.Cryptocurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public abstract class OptionBuilder {
    private Cryptocurrency criptocurrency;
    private UserCrypto user;
    private float cryptoAmount = 0 ;
    private  double price = 0.00;
    private OptionType tyoe ;


  // public static OptionBuilder anOption() {};


    public OptionBuilder withCryptoAmount(float aCryptoAmount)
    {   cryptoAmount = cryptoAmount;
        return this;
    }

    public OptionBuilder withPrice(double aPrice)
    {
        price = aPrice;
        return this;
    }

    public OptionBuilder withCryptoCurrency (Cryptocurrency aCryptocurrency)
    {
        criptocurrency = aCryptocurrency;
        return this;
    }

    public OptionBuilder withUser (UserCrypto anUser)
    {
        user =  anUser;
        return this;
    }

    public abstract  Option build();


}
