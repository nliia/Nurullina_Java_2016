package ru.itis.kpfu.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Liia on 16.11.2016.
 */
public class ErrorLogger extends Logger {

    public ErrorLogger() {
        this.level = "ERROR";
    }

    @Override
    protected void log(String message) {
        super.log(message);
    }
}
