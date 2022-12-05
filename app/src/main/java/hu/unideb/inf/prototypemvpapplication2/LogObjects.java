package hu.unideb.inf.prototypemvpapplication2;


/*
* -> FATAL	100	The application is unusable. Action needs to be taken immediately.
* -> ERROR	200	An error occurred in the application.
* -> WARN	300	Something unexpected—though not necessarily an error—happened and needs to be watched.
* -> INFO	400	A normal, expected, relevant event happened.
* -> DEBUG	500	Used for debugging purposes
* -> TRACE	600	Used for debugging purposes—includes the most detailed information
*/


import android.annotation.SuppressLint;
import android.os.Debug;
import android.util.Log;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

// logoláshoz használt osztály, amely olyan tagokat tartalmaz, amelyek segítségével a program futása során keletkező hibákat és program használatát tudjuk nyilvántartani
public class LogObjects {

    private final LogLevel loggingLevel;
    private final StackTraceElement stackTraceElement;
    private final String zonedDateTime;
    private final String message;

    public LogObjects(LogLevel loggingLevel, StackTraceElement stackTraceElement, String zonedDateTime, String message) {
        this.loggingLevel = loggingLevel;
        this.stackTraceElement = stackTraceElement;
        this.zonedDateTime = zonedDateTime;
        this.message = message;
    }

    public LogLevel getLoggingLevel() {
        return loggingLevel;
    }

    public String getZonedDateTime() {
        return zonedDateTime;
    }

    public String getMessage() {
        return message;
    }

    public String getStackTraceClassName(){
        return this.stackTraceElement.getClassName();
    }

    public String getStackTraceFileName(){
        return this.stackTraceElement.getFileName();
    }

    public int getStackTraceLineNumber(){
        return this.stackTraceElement.getLineNumber();
    }

    public String getStackTraceMethodName(){
        return this.stackTraceElement.getMethodName();
    }

    public static LogObjects error(String errorMeesage){

        // -> 4. színtű Trace bejegyzés lekérdezése a Stack Traceből
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];

        // idő lekédezése
        String zonedDateTime = getUTCDateTimeString();

        LogObjects logObject = new LogObjects(LogLevel.ERROR, stackTraceElement, zonedDateTime, errorMeesage);

        Log.e("k:", logObject.toString());

        return logObject;
    }

    public static void error(Exception exceptionObject){}

    public static String getUTCDateTimeString(){
        Calendar date = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        return df.format(date.getTimeInMillis()) + " " + date.getTimeZone().getID();
    }

    @NonNull
    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("[%s] -> (%s) - Üzenet: %s, Fájlnév: %s, Osztálynév: %s, Függvény: %s, Hibasor: %d",
                this.getLoggingLevel(),
                this.getZonedDateTime(),
                this.getMessage(),
                this.getStackTraceFileName(),
                this.getStackTraceClassName(),
                this.getStackTraceMethodName(),
                this.getStackTraceLineNumber());
    }
}
