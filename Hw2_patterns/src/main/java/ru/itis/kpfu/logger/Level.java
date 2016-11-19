package ru.itis.kpfu.logger;

/**
 * Created by Liia on 19.11.2016.
 */
public enum Level {
    WARN, ERROR, INFO {
        public String toString() {
            return "(INFO|ERROR)";
        }
    }
}

