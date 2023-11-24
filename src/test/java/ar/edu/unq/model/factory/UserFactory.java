package ar.edu.unq.model.factory;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.UserLoginDto;
import ar.edu.unq.cryptop2p.model.dto.UserRegisterDto;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

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

    public static UserRegisterDto aUserRegisterDtoWithEmail(String anEmail)  {
        var user =  new UserRegisterDto("Victor","Hugo", "Francia 123" , "Very_Secret!", anEmail,  "123456789_123456789_12", "12345678");
       return user;
    }

    public static UserRegisterDto aUserRegisterDto()  {
        var user =  new UserRegisterDto("Victor","Hugo", "Francia 123" , "Very_Secret!", "victorhugo@gmail.com",  "123456789_123456789_12", "12345678");
        return user;
    }

    public static String aUserLoginDtoAsString() throws JsonProcessingException {
        var userLogin =  new UserLoginDto("victorhugo@gmail.com","Very_Secret!");
        return getBody(userLogin);
    }

    public static String aUserRegisterDtoAsString() throws JsonProcessingException {
        var user =  new UserRegisterDto("Victor","Hugo", "Francia 123" , "Very_Secret!", "victorhugo@gmail.com",  "123456789_123456789_12", "12345678");
        return getBody(user);
    }

    public static String getBody(final Object user) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(user);
    }

    public static  HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }


}
