package ar.edu.unq.cryptop2p.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AddressException extends Exception
{
    public AddressException(String msg)
    {
        super(msg);
    }
}
