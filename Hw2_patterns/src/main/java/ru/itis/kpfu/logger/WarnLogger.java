package ru.itis.kpfu.logger;

/**
 * Created by Liia on 16.11.2016.
 */
public class WarnLogger extends Logger {
    public WarnLogger() {
        setLevelAndCheckMessage(Level.WARN);
    }
}
