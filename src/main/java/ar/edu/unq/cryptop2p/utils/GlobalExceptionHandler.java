package ar.edu.unq.cryptop2p.utils;


import ar.edu.unq.cryptop2p.model.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static ar.edu.unq.cryptop2p.model.validators.Validator.*;

import java.util.HashMap;

@ControllerAdvice
public class  GlobalExceptionHandler {
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
          HashMap result = getResponse();
        return  ResponseEntity.status(400).body(result);
    }


    @ExceptionHandler({ NotFoundException.class})
    public ResponseEntity<Object> handleSNotFoundException( NotFoundException exception) {
         HashMap result = getResponse();
         return  ResponseEntity.status(404).body(result);

    }


    @ExceptionHandler({ PreconditionFailedException.class})
    public ResponseEntity<Object> handlePreconditionFailedException( PreconditionFailedException  exception) {
        HashMap result = getResponse();
        return  ResponseEntity.status(400).body(result);
    }


    @ExceptionHandler({ DollarProxyServerException.class})
    public ResponseEntity<Object> handleDollarProxyServerException ( DollarProxyServerException exception) {
        HashMap result = getResponse();
        return  ResponseEntity.ok().body(result);
    }



    @ExceptionHandler({ CancelException.class})
    public ResponseEntity<Object> handleCancelException ( CancelException   exception) {
        HashMap result = getResponse();
        return  ResponseEntity.ok().body(result);
    }


    @ExceptionHandler({ ConfirmReceptionException.class})
    public ResponseEntity<Object> handleConfirmReceptionException ( ConfirmReceptionException   exception) {
        HashMap result = getResponse();
        return  ResponseEntity.ok().body(result);
    }



    @ExceptionHandler({ MakeTransferException.class})
    public ResponseEntity<Object> handleMakeTransferException ( MakeTransferException  exception) {
        HashMap result = getResponse();
        return  ResponseEntity.ok().body(result);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
               return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());

    }}
