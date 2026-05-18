package com.Affordmed.LoggingMiddleware.LoggingMiddleware.logger;



public class LogFormatter {

    public String format(LogEntry logEntry) {

        return
                "[" + logEntry.getTimestamp() + "] " +
                "[" + logEntry.getLevel() + "] " +
                "[" + logEntry.getApplication() + "] " +
                logEntry.getMessage();
    }
}