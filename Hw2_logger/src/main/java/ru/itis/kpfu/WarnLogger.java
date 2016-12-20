package ru.itis.kpfu;

/**
 * Created by Liia on 16.11.2016.
 */
public class WarnLogger extends Logger {
    public WarnLogger(int level){
        this.priority = level;
    }
    @Override
    void writeMessage(String message) {
        System.out.println("WARN:" + message);
    }
}
