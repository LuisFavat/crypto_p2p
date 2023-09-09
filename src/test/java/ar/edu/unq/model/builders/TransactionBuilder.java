package ar.edu.unq.model.builders;

import org.springframework.data.projection.TargetAware;

import ar.edu.unq.cryptop2p.model.*;
import ar.edu.unq.cryptop2p.model.Transaction;

public class TransactionBuilder {

    private String address = "no address";
    private Cryptocurrency crypto;
    private float amountOfCrypto;
    private UserCrypto buyer;
    private UserCrypto seller;
    private Option option;

    public static TransactionBuilder aTransaction()
    {
        return new TransactionBuilder();
    }

    public TransactionBuilder withOption(Option aOption)
    {
        option = aOption;
        return this;
    }

    public Transaction build()
    {
        Transaction transaction = new Transaction( option);
        return transaction;
    }

    
}

