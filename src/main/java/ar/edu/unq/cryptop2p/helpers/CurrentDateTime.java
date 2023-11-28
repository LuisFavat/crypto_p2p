package ar.edu.unq.cryptop2p.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

public class CurrentDateTime {

    private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private static final String DATE_FORMAT2 = "dd/MM/yyyy";
    private  static final  long CURRENT_TIME_MINUS_30_MINUTES_IN_MILLISECONDS = ZonedDateTime.now().minusMinutes(30).toInstant().toEpochMilli();
    private static final long currentTimeInMilliseconds = ZonedDateTime.now().toInstant().toEpochMilli();
    private static final long currentTimeMinusOneDayInMilliseconds = ZonedDateTime.now().minusDays(1).toInstant().toEpochMilli();

    private CurrentDateTime() {}

    public static Date getNewDate(){
        return new Date();
        }

    public static String getNewDateString(){
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(getNewDate());
    }

    public static String dateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
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


    public  static long getCurrentTimeMinusOneDayInMilliseconds() {
        return currentTimeMinusOneDayInMilliseconds;
    }


    public static long getCurrentTimeMinus30MinutesInMilliseconds() {
        return CURRENT_TIME_MINUS_30_MINUTES_IN_MILLISECONDS;
    }


}


