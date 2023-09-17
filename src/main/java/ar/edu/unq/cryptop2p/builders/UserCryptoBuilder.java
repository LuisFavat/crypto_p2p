package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.model.Bank;
import ar.edu.unq.cryptop2p.model.UserCrypto;

public class UserCryptoBuilder {

    private long id        = 0L;
    private String name    = "empty name";
    private String surname = "empty surname";
    private String address = "empty address";
    private String email   = "empty email";
    private String cvu     = "empty cvu";
    private String cryptoAddress = "empty address";
    private int numberOfOperations = 0;
    private int reputation = 0;
    private int scores = 0;
    private Bank bank ;


    public static UserCryptoBuilder aUserCrypto()
    {
        return new UserCryptoBuilder();
    }

    public UserCryptoBuilder withId(long aId)
    {
        id = aId;
        return this;
    }

    public UserCryptoBuilder withName(String aName)
    {
        name = aName;
        return this;
    }

    public UserCryptoBuilder withSurname(String aSurname)
    {
        surname = aSurname;
        return this;
    }
    
    public UserCryptoBuilder withAddress(String anAddress)
    {
        address = anAddress;
        return this;
    }

    public UserCryptoBuilder withEmail(String aEmail)
    {
        email = aEmail;
        return this;
    }
     
    public UserCryptoBuilder withCvu(String aCvu)
    {
        cvu = aCvu;
        return this;
    }
     
    public UserCryptoBuilder withCryptoAddress(String aCryptoAddress)
    {
        cryptoAddress = aCryptoAddress;
        return this;
    }
     
    public UserCryptoBuilder withNumberOfOperation(int aNumberOfOperations)
    {
        numberOfOperations = aNumberOfOperations;
        return this;
    }
     
    public UserCryptoBuilder withReputation(int aReputation)
    {
        reputation = aReputation;
        return this;
    }

    public UserCryptoBuilder withBank(Bank aBank)
    {
        bank = aBank;
        return this;
    }

    public UserCrypto build()
    {
        var user = new UserCrypto(id, name, surname, address, email, cvu, cryptoAddress);
        user.setReputation(reputation);
        user.setNumberOfOperation(numberOfOperations);
        user.setScores(scores);
        user.setBank(bank);
        return user;
    }

}
