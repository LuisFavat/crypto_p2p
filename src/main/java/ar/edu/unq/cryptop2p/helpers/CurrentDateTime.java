package ar.edu.unq.cryptop2p.helpers;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

public class CurrentDateTime {

    private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private  static final  long CURRENT_TIME_MINUS_30_MINUTES_IN_MILLISECONDS = ZonedDateTime.now().minusMinutes(30).toInstant().toEpochMilli();


    private CurrentDateTime() {}

    public static Date getNewDate(){
        return new Date();
        }

    public static String getNewDateString(){
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(getNewDate());
    }


    public static long getCurrentTimeMinus30MinutesInMilliseconds() {
        return CURRENT_TIME_MINUS_30_MINUTES_IN_MILLISECONDS;
    }

}


