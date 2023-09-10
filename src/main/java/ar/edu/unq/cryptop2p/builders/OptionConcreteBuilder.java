package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.*;

public class OptionConcreteBuilder {
    private Cryptocurrency criptocurrency;
    private UserCrypto user;
    private int units = 0 ;
    private  double price = 0.00;
    private OptionType tyoe ;

    public static OptionConcreteBuilder anyOption() {return new OptionConcreteBuilder(); }

    public OptionConcreteBuilder withUnits(int anyUnits)
    {   units = anyUnits;
        return this;
    }

    public OptionConcreteBuilder withPrice(double aPrice)
    {
        price = aPrice;
        return this;
    }

    public OptionConcreteBuilder withCryptoCurrency (Cryptocurrency aCryptocurrency)
    {
        criptocurrency = aCryptocurrency;
        return this;
    }

    public OptionConcreteBuilder withUser (UserCrypto anUser)
    {
        user =  anUser;
        return this;
    }

    public Option build ()  { return new OptionCall(criptocurrency,  price,  units, user);}
}
