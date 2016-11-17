package ru.itis.kpfu.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Liia on 16.11.2016.
 */
public class InfoLogger extends Logger {
    public InfoLogger() {
        this.level = "INFO";
    }


    @Override
    void log(String message) {
        Pattern p = Pattern.compile("\\[(INFO|ERROR)\\] : (?<message>\\[[a-zA-Z -]*\\])");
        Matcher m = p.matcher(message);
        if (m.matches()) {

            writeMessage(m.group("message"));

        }
        if (next != null) {
            next.log(message);
        }
    }

    protected void writeMessage(String message) {
        System.out.println(message);
    }
}
