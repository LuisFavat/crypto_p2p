package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class OptionConcreteBuilder {
    private CryptoCurrency criptocurrency;
    private UserCrypto user;
    private float cryptoAmount = 0 ;
    private  double price = 0.00;
    private String address ="" ;
    private float reputation = 0;
    private int scores = 0;
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

    public OptionConcreteBuilder withCReputation(float aReputation)
    {   reputation = aReputation;
        return this;
    }

    public OptionConcreteBuilder withCScores(int  anyScores)
    {   scores = anyScores;
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

    public Option buildOptionCall ()  {  var optionCall = new OptionCall(criptocurrency,  price,  cryptoAmount, user);
              optionCall.setReputation(reputation);
              optionCall.setScores(scores);
              return optionCall ;}

    public Option buildOptionPut () {
        var optionPut = new OptionPut(criptocurrency, price, cryptoAmount, user);
        optionPut.setReputation(reputation);
        optionPut.setScores(scores);
          return optionPut; }
}
