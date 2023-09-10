<<<<<<< HEAD:src/main/java/ar/edu/unq/cryptop2p/builders/OptionBuilder.java
package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.Cryptocurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  abstract class OptionBuilder {
    private Cryptocurrency criptocurrency;
    private UserCrypto user;
    private int units = 0 ;
    private  double price = 0.00;
    private OptionType tyoe ;

   // public abstract OptionBuilder anOption() ;

    public OptionBuilder withUnits(int anyUnits)
    {   units = anyUnits;
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

    public abstract Option build () ;
}
=======
package ar.edu.unq.model.builders;

import ar.edu.unq.cryptop2p.model.Cryptocurrency;
import ar.edu.unq.cryptop2p.model.OptionCall;
import ar.edu.unq.cryptop2p.model.OptionPut;
import ar.edu.unq.cryptop2p.model.UserCrypto;

public class OptionBuilder {
    
    private Cryptocurrency cryptocurrency;
    private float cryptoAmount;
    private Double price;
    private UserCrypto interesedUser;
    //private String address;


    public static OptionBuilder aOption()
    {
        return new OptionBuilder();
    }

    public OptionBuilder withCryptocurrency(Cryptocurrency aCryptocurrency)
    {
        cryptocurrency = aCryptocurrency;
        return this;
    }
 
    public OptionBuilder withCryptoAmount(float aCryptoAmount)
    {
        cryptoAmount = aCryptoAmount;
        return this;
    }

    public OptionBuilder withPrice(Double aPrice)
    {
        price = aPrice;
        return this;
    }
 
    public OptionBuilder withUser(UserCrypto aUserCrypto)
    {
        interesedUser = aUserCrypto;
        return this;
    }
     /* 
    public OptionBuilder withAddress(String anAddress)
    {
        address = anAddress;
        return this;
    }*/


       public OptionCall build()
    {
        return new OptionCall(cryptocurrency, price, cryptoAmount, interesedUser);
    }

    public OptionCall builOptionCall()
    {
        return new OptionCall(cryptocurrency, price, cryptoAmount, interesedUser);
    }
 
    public OptionPut builOptionPut()
    {
        return new OptionPut(cryptocurrency, price, cryptoAmount, interesedUser);
    }

}
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733:src/test/java/ar/edu/unq/model/builders/OptionBuilder.java
