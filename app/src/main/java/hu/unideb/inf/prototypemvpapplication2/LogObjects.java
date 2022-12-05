package hu.unideb.inf.prototypemvpapplication2;


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
    private StackTraceElement stackTraceElement;
    private String zonedDateTime;
    private String message;

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
}
