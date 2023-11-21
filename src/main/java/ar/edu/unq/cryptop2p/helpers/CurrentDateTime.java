package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.dto.TransactionViewDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;

import static ar.edu.unq.cryptop2p.model.validators.Validator.getResponse;

public class CurrentDateTime {

    private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private static final String DATE_FORMAT2 = "dd/MM/yyyy";
    private  static final  long CURRENT_TIME_MINUS_30_MINUTES_IN_MILLISECONDS = ZonedDateTime.now().minusMinutes(30).toInstant().toEpochMilli();
    private static final long currentTimeInMilliseconds = ZonedDateTime.now().toInstant().toEpochMilli();
    private static final long currentTimeMinusOneDayInMilliseconds = ZonedDateTime.now().minusDays(1).toInstant().toEpochMilli();
    private static final long currentTimeInMillisecondsFromSystem = System.currentTimeMillis();


    private CurrentDateTime() {}

    public static Date getNewDate(){
        return new Date();
        }

    public static Date getTimeStamp(){
        return new Date(currentTimeInMillisecondsFromSystem);
    }

    public static Date getExpirationTime() {return new Date(currentTimeInMillisecondsFromSystem + 3600000);}

    public static String getNewDateString(){
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(getNewDate());
    }

    public static  Date  stringToDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT2);
        Date date = formatter.parse(dateString);
        return date;
    }

    public static String longToDate (long timeInLong) {
        var date = getNewDate();
        date.setTime(timeInLong);
        return new SimpleDateFormat().format(date);
    }


    public static long getCurrentTimeInMilliseconds() {
        return currentTimeInMilliseconds;
    }

    public static long getCurrentTimeInMillisecondsFromSystem() {
        return currentTimeInMillisecondsFromSystem;
    }

    public  static long getCurrentTimeMinusOneDayInMilliseconds() {
        return currentTimeMinusOneDayInMilliseconds;
    }

    /*
    public static  LocalDate  stringToDate(String dateString)  {
       LocalDate date = null;
        try {
             date = LocalDate.parse(dateString);
        } catch (Exception e) {
         e.fillInStackTrace();
        }
        return date;
     }
     */

/*
    ResponseEntity response;
        try {
        TransactionViewDto entity = TransactionViewDto.fromModel(transactionService.create(transactionData.getIdOption(), transactionData.getIdCounterParty()));
        ResponseEntity.status(201);
        response = ResponseEntity.ok().body(entity);
    } catch (Exception  e) {

        HashMap result = getResponse();
        response = ResponseEntity.ok().body(result);
    }
        return response ;
}

*/
    public static long getCurrentTimeMinus30MinutesInMilliseconds() {
        return CURRENT_TIME_MINUS_30_MINUTES_IN_MILLISECONDS;
    }


}


