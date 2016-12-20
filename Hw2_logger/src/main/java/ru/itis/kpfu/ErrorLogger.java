package ru.itis.kpfu;

/**
 * Created by Liia on 16.11.2016.
 */
public class ErrorLogger extends Logger {
    public ErrorLogger(int level){
        this.priority = level;
    }
    @Override
    void writeMessage(String message) {
        System.out.println("ERROR:" + message);
        if(this.next != null){
            next.writeMessage(message);
        }
    }
}
