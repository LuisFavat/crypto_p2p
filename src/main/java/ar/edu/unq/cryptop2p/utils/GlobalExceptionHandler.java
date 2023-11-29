package ar.edu.unq.cryptop2p.utils;


import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.NotFoundException;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static ar.edu.unq.cryptop2p.model.validators.Validator.*;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
       /*
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    */
        HashMap result = getResponse();
        return  ResponseEntity.ok().body(result);
    }


    @ExceptionHandler({ NotFoundException.class})
    public ResponseEntity<Object> handleSNotFoundException( NotFoundException exception) {
       /*
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
               .body(exception.getMessage());
         */
         HashMap result = getResponse();
         return  ResponseEntity.ok().body(result);

    }


    @ExceptionHandler({ PreconditionFailedException.class})
    public ResponseEntity<Object> handlePreconditionFailedException( PreconditionFailedException  exception) {
      /*
        return ResponseEntity
                .status(HttpStatus.PRECONDITION_FAILED)
                .body(exception.getMessage());
    */
        HashMap result = getResponse();
        return  ResponseEntity.ok().body(result);
    }



    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
       /*
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
   */
        HashMap result = getResponse();
        return  ResponseEntity.ok().body(result);
    }}
