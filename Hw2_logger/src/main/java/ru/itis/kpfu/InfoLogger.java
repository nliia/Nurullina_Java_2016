package ru.itis.kpfu;

/**
 * Created by Liia on 16.11.2016.
 */
public class InfoLogger extends Logger {

    public InfoLogger(int level){
        this.priority = level;
    }
    @Override
    void writeMessage(String message) {

        System.out.println("INFO:" + message);
    }
}
