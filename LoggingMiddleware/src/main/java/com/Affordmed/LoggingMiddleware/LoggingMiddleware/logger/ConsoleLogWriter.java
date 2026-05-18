package com.Affordmed.LoggingMiddleware.LoggingMiddleware.logger;



public class ConsoleLogWriter implements LogWriter {

    private final LogFormatter formatter;

    public ConsoleLogWriter() {

        this.formatter = new LogFormatter();
    }

    @Override
    public void write(LogEntry logEntry) {

        String formattedLog =
                formatter.format(logEntry);

        System.out.println(formattedLog);
    }
}