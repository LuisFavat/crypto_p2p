package ar.edu.unq.model.factory;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;

public class UserFactory {

    public static UserCrypto aUserWithPassword(String aPassword) throws PreconditionFailedException {
    var user = new UserCrypto(1L,"Victor","Hugo", "Francia 123" , aPassword, "victorhugo@gmail.com", "123456789_123456789_12", "12345678");
      //  try {
            user.validate();
    //} catch (Exception e) {
      //  e.fillInStackTrace();
    //}
        return user;
       }

    public static UserCrypto aUserWithName(String aName) throws  PreconditionFailedException {
       var user =   new UserCrypto(1L,aName,"Hugo", "Francia 123", "Very_Secret!", "victorhugo@gmail.com", "123456789_123456789_12", "12345678");
       user.validate();
       return user;
    }
    public static UserCrypto aUserWithLastName(String aLastName) throws  PreconditionFailedException {
        var user = new UserCrypto(1L,"Victor", aLastName,"Francia 123" ,  "Very_Secret!","victorhugo@gmail.com", "123456789_123456789_12", "12345678");
        user.validate();
        return user;
    }

    public static UserCrypto aUserWithEmail(String anEmail) throws  PreconditionFailedException {
        var user = new UserCrypto(1L,"Victor","Hugo","Francia 123" ,"Very_Secret!", anEmail,  "123456789_123456789_12", "12345678");
        user.validate();
        return user;
    }
    public static UserCrypto aUserWithCVU(String aCvu) throws  PreconditionFailedException {
        var user = new UserCrypto(1L,"Victor","Hugo","Francia 123" , "Very_Secret!","victorhugo@gmail.com",  aCvu, "12345678");
        user.validate();
        return user;
    }
    public static UserCrypto aUserWithCryptoAddress(String aCryptoAddress) throws  PreconditionFailedException {
        var user =  new UserCrypto(1L,"Victor","Hugo","Francia 123" , "Very_Secret!","victorhugo@gmail.com",  "123456789_123456789_12", aCryptoAddress);
        user.validate();
        return user;
    }
    public static UserCrypto aUserWithAddress(String aAddress) throws  PreconditionFailedException {
        var user =  new UserCrypto(1L,"Victor","Hugo", aAddress , "Very_Secret!", "victorhugo@gmail.com",  "123456789_123456789_12", "12345678");
        user.validate();
        return user;
    }
}
