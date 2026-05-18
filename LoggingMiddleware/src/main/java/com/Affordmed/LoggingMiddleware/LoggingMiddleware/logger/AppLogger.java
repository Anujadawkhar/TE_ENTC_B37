package com.Affordmed.LoggingMiddleware.LoggingMiddleware.logger;



import java.time.LocalDateTime;

public class AppLogger {

    private final LogWriter writer;
    private final String applicationName;

    public AppLogger(
            String applicationName,
            LogWriter writer
    ) {
        this.applicationName = applicationName;
        this.writer = writer;
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    public void debug(String message) {
        log("DEBUG", message);
    }

    private void log(String level, String message) {

        LogEntry entry = new LogEntry(
                LocalDateTime.now(),
                level,
                applicationName,
                message
        );

        writer.write(entry);
    }
}