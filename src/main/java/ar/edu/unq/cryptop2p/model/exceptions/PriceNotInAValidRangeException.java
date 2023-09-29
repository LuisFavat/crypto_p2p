package ar.edu.unq.cryptop2p.model.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
public class PriceNotInAValidRangeException extends Exception {


    public PriceNotInAValidRangeException(String message) {super(message); }
}