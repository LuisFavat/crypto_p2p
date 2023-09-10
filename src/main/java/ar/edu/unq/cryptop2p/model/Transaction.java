package ar.edu.unq.cryptop2p.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Transaction {

    private Option option;

    public Transaction( Option aOption)
    {
        option  = aOption;
    }

    public String getAddress()
    {
        return option.getVirtualAddress();
    }

    public Cryptocurrency getCryptoCurrency()
    {
        return option.getCryptocurrency();
    }

    public float getAmountOfCryptoCurrency()
    {
        return option.getCryptoAmount();
    }

    public Double cryptoPrice()
    {
        return option.quote();
    }

    public Double transactionAmount()
    {
        return getAmountOfCryptoCurrency() * cryptoPrice();
    }

    public String nameOfTheOwnerOfTheOption()
    {
        return option.nameOfTheOwner();
    }
     
    public int  numberOfOperations()
    {
        return option.numberOfOperation();
    }

    public int reputation()
    {
        return option.reputation();
    }

    public String address()
    {
        return option.getAddress();
    }
}
