package ar.edu.unq.model.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import static ar.edu.unq.model.factory.UserFactory.*;


public class AuthFactory {

     public static  HttpEntity<String> getRegistrationEntity() throws JsonProcessingException {
       return new HttpEntity<>(aUserRegisterDtoAsString(), getHeaders());
    }

    public static HttpEntity<String> getAuthenticationEntity() throws JsonProcessingException {
        return new HttpEntity<>(aUserLoginDtoAsString(), getHeaders());
    }
}
