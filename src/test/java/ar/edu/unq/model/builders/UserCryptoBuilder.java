package ar.edu.unq.model.builders;

import ar.edu.unq.cryptop2p.model.UserCrypto;

public class UserCryptoBuilder {

    private long id        = 0L;
    private String name    = "empty name";
    private String surname = "empty surname";
    private String address = "empty address";
    private String email   = "empty email";
    private String cvu     = "empty cvu";
    private String cryptoAddress = "empty address";


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

    public UserCrypto build()
    {
        return new UserCrypto(id, name, surname, address, email, cvu, cryptoAddress);
    }

}