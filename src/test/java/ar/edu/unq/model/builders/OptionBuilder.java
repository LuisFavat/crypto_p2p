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
