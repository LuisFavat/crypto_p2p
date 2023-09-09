package ar.edu.unq.cryptop2p.model;

public class Transaction {

    //private Cryptocurrency cryptoCurrency;//option
    private String address;//option
    private float amountOfCryptoCurrency;//option
    private UserCrypto userOwnerOfTheOption;//option o el seller
    private UserCrypto userInteresed;
    private int sellerReputation;//user
    private Option option;

    public Transaction(/*Cryptocurrency aCryptoCurrency ,*/ float aNominalAmount, String aAddress, UserCrypto aBuyer, UserCrypto aSeller, Option aOption)
    {
        //cryptoCurrency         = aCryptoCurrency;
        amountOfCryptoCurrency = aNominalAmount;
        address = aAddress;
        userOwnerOfTheOption   = aBuyer;
        userInteresed  = aSeller;
        option  = aOption;
    }

    public Transaction() {
    }

    public String getAddress()
    {
        return option.getAddress();
    }

    public Cryptocurrency getCryptoCurrency() {
        //return cryptoCurrency;
        return option.getCryptocurrency();
    }

    public float getAmountOfCryptoCurrency()
    {
        //return amountOfCryptoCurrency;
        return option.getUnits();
    }

    public Double cryptoPrice()
    {
        //return 1D;//cryptoCurrency.getPrice();
        return option.quote();
    }

    public Double transactionAmount()
    {
        return getAmountOfCryptoCurrency() * cryptoPrice();
    }

    public String nameOfTheOwnerOfTheOption()
    {
        return option.nameOfTheOwner();//userOwnerOfTheOption.getName() + " " + userOwnerOfTheOption.getSurname();
    }
     
    public String sellerName()
    {
        return userInteresed.getName() + " " + userInteresed.getSurname();
    }

    public int  numberOfOperations()
    {
        return option.numberOfOperation();//userOwnerOfTheOption.getNumberOfOperation();
    }

    public void takeSellerReputation()
    {
        sellerReputation = userInteresed.getReputation();
    }

    public int reputation()
    {
        //return sellerReputation;
        return option.reputation();
    }

    public String address()
    {
        return option.getAddress();
    }
}
