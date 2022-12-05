package hu.unideb.inf.prototypemvpapplication2;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MyLogger {

    // ide kerülnek azok a statikus függvények, amelyek a debug üzeneteket írják ki különböző helyekre
    // mind a felhasználószíntű, mind a rendszerszíntű hibák is ide kerülnek

    /*
    public static void debug(List<LogObjects> listOfLogObjects){}
    public static void info(List<LogObjects> listOfLogObjects){}
    public static void warning(List<LogObjects> listOfLogObjects){}
    public static void error(List<LogObjects> listOfLogObjects){}
    public static void fatal(List<LogObjects> listOfLogObjects){}
    public static void trace(List<LogObjects> listOfLogObjects){}
     */

    public static LogObjects error(String errorMeesage){

        StackTraceElement stackTraceElement = getStackTraceElement(4);
        String zonedDateTime = getUTCDateTimeString();

        /*Log.e("x:", zonedDateTime);
        Log.e("ü:", stackTraceElement.getClassName());
        Log.e("ü:", stackTraceElement.getFileName());
        Log.e("ü:", String.valueOf(stackTraceElement.getLineNumber()));
        Log.e("ü:", stackTraceElement.getMethodName());*/

        LogObjects logObjects = new LogObjects(LogLevel.ERROR, stackTraceElement, zonedDateTime, errorMeesage);

        return null;
    }

    public static StackTraceElement getStackTraceElement(int traceLevel){
        /*StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for(int i = 0; i < stackTraceElements.length; i++){
            Log.e("ü:", stackTraceElements[i].getClassName() + "-" + stackTraceElements[i].getFileName() + "-" + stackTraceElements[i].getLineNumber() + "-" + stackTraceElements[i].getMethodName());
        }*/

        return Thread.currentThread().getStackTrace()[traceLevel];
    }

    public static String getUTCDateTimeString(){
        Calendar date = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        return df.format(date.getTimeInMillis()) + " " + date.getTimeZone().getID();
    }

    public static void error(Exception exceptionObject){}
}
