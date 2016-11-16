package ru.itis.kpfu;

import java.util.Scanner;

/**
 * Created by Liia on 16.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Put message:");
        String info = sc.nextLine();
        System.out.println("Put message for logger");
        String str = sc.nextLine();
        String[] arr = info.split(" ");
        int level = Integer.parseInt(arr[1]);
        Logger logger = getLog(level);
        logger.writeMessage(str);
    }

    private static Logger getLog(int level) {
        Logger errorLogger = new ErrorLogger(Level.ERROR);
        Logger warnLogger = new WarnLogger(Level.WARN);
        Logger infoLogger = new InfoLogger(Level.INFO);

        errorLogger.setNext(infoLogger);

        if(level == 1)
            return infoLogger;
        if(level == 2)
            return warnLogger;

            return errorLogger;
    }
}
