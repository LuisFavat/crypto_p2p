package ar.edu.unq.cryptop2p.model;

public class Transaction {

    private Option option;

    public Transaction( Option aOption)
    {
        option  = aOption;
    }

    public String getAddress()
    {
        return option.getAddress();
    }

    public Cryptocurrency getCryptoCurrency()
    {
        return option.getCryptocurrency();
    }

    public float getAmountOfCryptoCurrency()
    {
        return option.getUnits();
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
