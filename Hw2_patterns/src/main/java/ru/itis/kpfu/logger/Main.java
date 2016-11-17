package ru.itis.kpfu.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Liia on 16.11.2016.
 */
public class Main {
    public static void main(String[] args) {

        Logger infoLogger = new InfoLogger();
        Logger warnLogger = new WarnLogger();
        Logger errorLogger = new ErrorLogger();

        warnLogger.setNext(errorLogger);
        infoLogger.setNext(warnLogger);

        String infoMessage = "[INFO] : [some info here]";
        String warnMessage = "[WARN] : [warning]";
        String errorMessage = "[ERROR] : [exception in some modules]";
        String invalidMessage = "[LOL] : [lol lol]";

        List<String> messages = new ArrayList<>();
        messages.add(infoMessage);
        messages.add(warnMessage);
        messages.add(errorMessage);
        messages.add(invalidMessage);

        messages.forEach(infoLogger::log);

    }
}
