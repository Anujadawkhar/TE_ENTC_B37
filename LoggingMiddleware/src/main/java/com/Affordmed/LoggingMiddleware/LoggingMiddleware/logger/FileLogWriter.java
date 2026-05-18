package com.Affordmed.LoggingMiddleware.LoggingMiddleware.logger;


import java.io.FileWriter;
import java.io.IOException;



public class FileLogWriter implements LogWriter {

    private static final String LOG_FILE =
            "application.log";

    private final LogFormatter formatter;

    public FileLogWriter() {

        this.formatter = new LogFormatter();
    }

    @Override
    public void write(LogEntry logEntry) {

        String formattedLog =
                formatter.format(logEntry);

        try (FileWriter writer =
                     new FileWriter(LOG_FILE, true)) {

            writer.write(formattedLog);

            writer.write(System.lineSeparator());

        } catch (IOException exception) {

            System.out.println(
                    "Failed to write log : " +
                    exception.getMessage()
            );
        }
    }
}