package ru.itis.kpfu.logger;

/**
 * Created by Liia on 16.11.2016.
 */
public class WarnLogger extends Logger {
    public WarnLogger() {
        this.level = "WARN";
    }

    @Override
    protected void log(String message) {
        super.log(message);
    }
}
