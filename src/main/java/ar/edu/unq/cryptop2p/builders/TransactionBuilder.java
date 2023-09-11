package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.model.*;
import ar.edu.unq.cryptop2p.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionBuilder {

    private String address = "no address";
    private CryptoCurrency crypto;
    private float amountOfCrypto;
    private UserCrypto buyer;
    private UserCrypto seller;
    private float units;
    private Double price;
    private Option option;

    public static TransactionBuilder aTransaction()
    {
        return new TransactionBuilder();
    }

    public TransactionBuilder withAddress(String aAddress)
    {
        address = aAddress;
        return this;
    } 

    public TransactionBuilder withCryptoCurrency(CryptoCurrency aCrypto)
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

    public TransactionBuilder withUnits(int anyUnits)
    {   units = anyUnits;
        return this;
    }

    public TransactionBuilder withPrice(double aPrice)
    {
        price = aPrice;
        return this;
    }

    public TransactionBuilder wwithOption(Option anOption)
    {
        option = anOption;
        return this;
    }


    public Transaction build()
    {
        Transaction transaction = new Transaction(option);
        return transaction;
    }

    
}




