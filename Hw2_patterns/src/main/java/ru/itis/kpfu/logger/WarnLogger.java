package ru.itis.kpfu.logger;

/**
 * Created by Liia on 16.11.2016.
 */
public class WarnLogger extends Logger {
    public WarnLogger() {
        this.level = "WARN";
    }


    @Override
    void log(String message) {

        String[] splitedMessage = message.split(" : ");
        String mesType = splitedMessage[0].substring(1, splitedMessage[0].length() - 1);
        if(mesType.equals(this.level)){
            writeMessage(splitedMessage[1]);
        }

        if(this.next != null){
            next.log(message);
        }
    }

    protected void writeMessage(String message){
        System.out.println(message);
    }
}
