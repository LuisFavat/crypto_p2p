package ar.edu.unq.model.builders;

import ar.edu.unq.cryptop2p.model.*;
import ar.edu.unq.cryptop2p.model.Transaction;

public class TransactionBuilder {

    private String address = "no address";
    private Cryptocurrency crypto;
    private float amountOfCrypto;
    private UserCrypto buyer;
    private UserCrypto seller;

    public static TransactionBuilder aTransaction()
    {
        return new TransactionBuilder();
    }

    public TransactionBuilder withAddress(String aAddress)
    {
        address = aAddress;
        return this;
    } 

    public TransactionBuilder withCryptoCurrency(Cryptocurrency aCrypto)
    {
        crypto = aCrypto;
        return this;
    } 

    public TransactionBuilder withAmountOfCryptoCurrency(float aNominalAmount)
    {
        amountOfCrypto = aNominalAmount;
        return this;
    } 

    public TransactionBuilder withBuyer(UserCrypto aBuyer)
    {
        buyer = aBuyer;
        return this;
    }

    public TransactionBuilder withSeller(UserCrypto aSeller)
    {
        seller = aSeller;
        return this;
    }


    public Transaction build()
    {
        Transaction transaction = new Transaction(crypto, amountOfCrypto, address, buyer, seller);
        return transaction;
    }

    
}

