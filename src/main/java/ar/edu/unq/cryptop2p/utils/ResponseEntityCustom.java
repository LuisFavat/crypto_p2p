package ar.edu.unq.cryptop2p.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseEntityCustom {
    Map<String, Object> body = new LinkedHashMap<>();


    public ResponseEntityCustom(String message) {
        body.put("timestamp: ", new Date());
        body.put("error message: ", message);
    }

    public ResponseEntity<?> getResponseEntityBadRequest(){
        body.put("status: ", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(body, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST);
    }


}