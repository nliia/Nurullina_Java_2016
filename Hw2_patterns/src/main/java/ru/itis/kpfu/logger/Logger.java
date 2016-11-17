package ru.itis.kpfu.logger;

/**
 * Created by Liia on 16.11.2016.
 */
public abstract class Logger {
    public String level;
    Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    abstract void writeMessage(String message);
    abstract void log(String message);
}
