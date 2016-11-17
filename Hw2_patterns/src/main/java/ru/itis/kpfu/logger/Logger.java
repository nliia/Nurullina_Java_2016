package ru.itis.kpfu.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Liia on 16.11.2016.
 */
public abstract class Logger {

    protected String level;
    protected Logger next;

    protected void setNext(Logger next) {
        this.next = next;
    }

    protected void log(String message) {
        Pattern p = Pattern.compile("^\\[" + level + "\\] : (?<message>\\[[a-zA-Z -]*\\])$");
        Matcher m = p.matcher(message);
        if (m.matches()) {

            System.out.println(m.group("message"));

        }

        if (this.next != null) {
            next.log(message);
        }
    }
}
