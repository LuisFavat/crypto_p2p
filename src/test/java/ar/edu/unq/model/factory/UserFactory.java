package ar.edu.unq.model.factory;
import ar.edu.unq.cryptop2p.model.UserCrypto;
public class UserFactory {

    public static UserCrypto aUserWithPassword(String aPassword) throws Exception {
        return new UserCrypto(1L,"Victor","Hugo", "Francia 123" , aPassword, "victorhugo@gmail.com", "123456789_123456789_12", "12345678");
    }

    public static UserCrypto aUserWithName(String aName) throws Exception {
        return new UserCrypto(1L,aName,"Hugo", "Francia 123", "Very_Secret!", "victorhugo@gmail.com", "123456789_123456789_12", "12345678");
    }
    public static UserCrypto aUserWithLastName(String aLastName) throws Exception {
        return new UserCrypto(1L,"Victor", aLastName,"Francia 123" ,  "Very_Secret!","victorhugo@gmail.com", "123456789_123456789_12", "12345678");
    }

    public static UserCrypto aUserWithEmail(String anEmail) throws Exception {
        return new UserCrypto(1L,"Victor","Hugo","Francia 123" ,"Very_Secret!", anEmail,  "123456789_123456789_12", "12345678");
    }
    public static UserCrypto aUserWithCVU(String aCvu) throws Exception {
        return  new UserCrypto(1L,"Victor","Hugo","Francia 123" , "Very_Secret!","victorhugo@gmail.com",  aCvu, "12345678");
    }
    public static UserCrypto aUserWithCryptoAddress(String aCryptoAddress) throws Exception {
        return  new UserCrypto(1L,"Victor","Hugo","Francia 123" , "Very_Secret!","victorhugo@gmail.com",  "123456789_123456789_12", aCryptoAddress);
    }
    public static UserCrypto aUserWithAddress(String aAddress) throws Exception {
        return  new UserCrypto(1L,"Victor","Hugo", aAddress , "Very_Secret!", "victorhugo@gmail.com",  "123456789_123456789_12", "12345678");
    }
}
