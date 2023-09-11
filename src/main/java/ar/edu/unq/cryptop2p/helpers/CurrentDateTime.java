package ar.edu.unq.cryptop2p.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTime {

    private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

	private CurrentDateTime() {}

    public static Date getNewDate(){
        return new Date();
        }

    public static String getNewDateString(){
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(getNewDate());
    }


}


