package hu.unideb.inf.prototypemvpapplication2;


import java.time.ZonedDateTime;


/*
* -> FATAL	100	The application is unusable. Action needs to be taken immediately.
* -> ERROR	200	An error occurred in the application.
* -> WARN	300	Something unexpected—though not necessarily an error—happened and needs to be watched.
* -> INFO	400	A normal, expected, relevant event happened.
* -> DEBUG	500	Used for debugging purposes
* -> TRACE	600	Used for debugging purposes—includes the most detailed information
*/


// logoláshoz használt osztály, amely olyan tagokat tartalmaz, amelyek segítségével a program futása során keletkező hibákat és program használatát tudjuk nyilvántartani
public class LogObjects {

    private LogLevel loggingLevel;
    private StackTraceElement traceElement;
    private String zonedDateTime;
    private String message;

    public LogObjects(LogLevel loggingLevel, StackTraceElement traceElement, String zonedDateTime, String message) {
        this.loggingLevel = loggingLevel;
        this.traceElement = traceElement;
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

    public String getClassName(){
        return this.traceElement.getClassName();
    }

    public String getFileName(){
        return this.traceElement.getFileName();
    }

    public int getLineNumber(){
        return this.traceElement.getLineNumber();
    }

    public String getMethodName(){
        return this.traceElement.getMethodName();
    }
}
