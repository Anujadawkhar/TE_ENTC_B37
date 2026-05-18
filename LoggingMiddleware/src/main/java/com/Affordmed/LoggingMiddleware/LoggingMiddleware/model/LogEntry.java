package com.Affordmed.LoggingMiddleware.LoggingMiddleware.model;

import java.time.LocalDateTime;

public class LogEntry {

    private LocalDateTime timestamp;

    private String level;

    private String applicationName;

    private String message;

    public LogEntry(
            LocalDateTime timestamp,
            String level,
            String applicationName,
            String message
    ) {
        this.timestamp = timestamp;
        this.level = level;
        this.applicationName = applicationName;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getMessage() {
        return message;
    }
}