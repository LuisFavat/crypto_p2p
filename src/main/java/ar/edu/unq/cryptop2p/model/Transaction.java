package ar.edu.unq.cryptop2p.model;

public class Transaction {

    private Cryptocurrency cryptoCurrency;
    private String address;
    private float amountOfCryptoCurrency;
    private UserCrypto buyer;
    private UserCrypto seller;
    private int sellerReputation;

    public Transaction(Cryptocurrency aCryptoCurrency , float aNominalAmount, String aAddress, UserCrypto aBuyer, UserCrypto aSeller)
    {
        cryptoCurrency         = aCryptoCurrency;
        amountOfCryptoCurrency = aNominalAmount;
        address = aAddress;
        buyer   = aBuyer;
        seller  = aSeller;
    }

    public Transaction() {
    }

    public String getAddress()
    {
        return address;
    }

    public Cryptocurrency getCryptoCurrency() {
        return cryptoCurrency;
    }

    public float getAmountOfCryptoCurrency()
    {
        return amountOfCryptoCurrency;
    }

    public Double cryptoPrice()
    {
        return cryptoCurrency.getPrice();
    }

    public Double transactionAmount()
    {
        return amountOfCryptoCurrency * cryptoPrice();
    }

    public String buyerName()
    {
        return buyer.getName() + " " + buyer.getSurname();
    }
     
    public String sellerName()
    {
        return seller.getName() + " " + seller.getSurname();
    }

    public int numberOfOperations()
    {
        return seller.getNumberOfOperation();
    }

    public void setSellerReputation()
    {
        sellerReputation = seller.getReputation();
    }

    public int getSellerReputation()
    {
        return sellerReputation;
    }
}
