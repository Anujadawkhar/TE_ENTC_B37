package com.Affordmed.LoggingMiddleware.LoggingMiddleware.logger;

import java.time.LocalDateTime;

public class LogEntry {

    private LocalDateTime timestamp;
    private String level;
    private String application;
    private String message;

    public LogEntry() {
    }

    public LogEntry(
            LocalDateTime timestamp,
            String level,
            String application,
            String message
    ) {
        this.timestamp = timestamp;
        this.level = level;
        this.application = application;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getApplication() {
        return application;
    }

    public String getMessage() {
        return message;
    }
}