package ar.edu.unq.cryptop2p.model.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@Setter
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidResourceException extends Exception {

               public InvalidResourceException(String message) {
               super(message);


           }

           public static  HttpStatus getStatus(){
                 return  HttpStatus.BAD_REQUEST;

           }
    }

