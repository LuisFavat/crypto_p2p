package ar.edu.unq.cryptop2p.model.exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{

    public NotFoundException(String message) {super(message);}

    public static  HttpStatus getStatus(){
        return  HttpStatus.NOT_FOUND;
    }
}
