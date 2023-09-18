package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.ActionType;
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
    private UserCrypto counterParty;
    private State state = new Idle();
    private Action action;
    private ActionType actionType;

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

    public TransactionBuilder withCounterPartyUser (UserCrypto aCounterParty)
    {
        counterParty = aCounterParty;
        return this;
    }

    public TransactionBuilder withState (State aState)
    {
        state = aState;
        return this;
    }

    public TransactionBuilder withActionType (ActionType anActionType)
    {
        actionType = anActionType;
        return this;
    }

    public TransactionBuilder withAction (Action anAction)
    {
        action = anAction;
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
        transaction.setCounterPartyUser(counterParty);
        transaction.setState(state);;
        transaction.setActionType(actionType);
        transaction.setAction(action);
        return transaction;
    }

    public Transaction buildWithoutOption()
    {
        Transaction transaction = new Transaction();
        transaction.setCounterPartyUser(counterParty);
        transaction.setState(state);
        transaction.setAction(action);
        transaction.setActionType(actionType);
        return transaction;
    }

    
}




