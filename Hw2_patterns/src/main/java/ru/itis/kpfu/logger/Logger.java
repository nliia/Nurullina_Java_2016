package ru.itis.kpfu.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by Liia on 16.11.2016.
 */
public abstract class Logger {

    protected Level[] levels;
    protected Logger next;

    protected Logger(Level... level) {
        levels = level;
    }

    protected void setNext(Logger next) {
        this.next = next;
    }

    protected void log(String message) {
        if (levels.length == 1) {
            messageChecker(message, levels[0].toString());
        } else {
            messageChecker(message, expPartCompiler(levels));
        }
    }

    private String expPartCompiler(Level[] levels) {
        StringBuilder expPart = new StringBuilder();
        expPart.append("(");

        for (int i = 0; i < levels.length; i++) {
            expPart = expPart.append(levels[i] + "|");
        }

        expPart.append(")");
        return expPart.toString();
    }

    private void messageChecker(String message, String level) {
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