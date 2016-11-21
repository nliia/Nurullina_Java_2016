package ru.itis.kpfu.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Logger {
    private Matcher m;
    private Pattern p;
    private Level[] levels;
    private Logger next;
    private String mainLevel;

    void setLevelAndCheckMessage(Level... level) {
        levels = level;
        if (levels.length == 1) {
            mainLevel = levels[0].toString();
        } else {
            mainLevel = expPartCompiler(levels);
        }
        p = Pattern.compile("^\\[" + mainLevel + "\\] : (?<message>\\[[a-zA-Z -]*\\])$");
    }

    void setNext(Logger next) {
        this.next = next;
    }

    void log(String message) {
        m = p.matcher(message);
        if (m.matches()) {
            System.out.println(m.group("message"));
        }
        if (next != null) {
            next.log(message);
        }
    }

    private String expPartCompiler(Level[] levels) {
        StringBuilder expPart = new StringBuilder();
        expPart.append("(");
        for (int i = 0; i < levels.length - 1; i++) {
            expPart.append(levels[i] + "|");
        }
        expPart.append(levels[levels.length - 1]);
        expPart.append(")");
        return expPart.toString();
    }
}