package ru.itis.kpfu;

/**
 * Created by Liia on 16.11.2016.
 */
public abstract class Logger {
    int priority;
    Logger next;

    public void setNext(Logger next){
        this.next = next;
    }
    public void logMessage(int level, String message){
        if(priority <= level)
            writeMessage(message);
        if(next != null)
            next.logMessage(level,message);
    }

    abstract void writeMessage(String message);
}
