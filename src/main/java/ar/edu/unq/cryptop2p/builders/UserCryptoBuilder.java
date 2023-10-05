package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCryptoBuilder {

    private long id        = 0L;
    private String name    = "Empty name";
    private String surname = "Empty surname";
    private String address = "Empty address";
    private String email   = "empty@email.com";
    private String cvu     = "1234567890123456789012";
    private String cryptoAddress = "12345678";
    private int numberOfOperations = 0;
    private int reputation = 0;
    private int scores = 0;



    public static UserCryptoBuilder aUserCrypto()
    {
        return new UserCryptoBuilder();
    }

    public static UserCryptoBuilder aUser()
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

    public UserCryptoBuilder withScores(int anyScores)
    {
        scores = anyScores;
        return this;
    }



    public UserCrypto build() throws PreconditionFailedException {
        var user = new UserCrypto(id, name, surname, address, "Very_Secret!", email, cvu, cryptoAddress);

        user.setReputation(reputation);
        user.setNumberOfOperation(numberOfOperations);
        user.setScores(scores);
      //  try {
         user.validate();
       // } catch (Exception e) {
         //   e.fillInStackTrace();
       // }
        return user;

          }

}
