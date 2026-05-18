package com.Affordmed.LoggingMiddleware.LoggingMiddleware.config;

import com.Affordmed.LoggingMiddleware.LoggingMiddleware.logger.*;
import com.Affordmed.LoggingMiddleware.LoggingMiddleware.middleware.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingAutoConfiguration {

    @Bean
    public AppLogger appLogger() {

        return new AppLogger(
                "Inventory-Service",
                new ConsoleLogWriter()
        );
    }

    @Bean
    public FilterRegistrationBean<RequestLoggingFilter> loggingFilter(
            AppLogger logger
    ) {

        FilterRegistrationBean<RequestLoggingFilter> registration =
                new FilterRegistrationBean<>();

        registration.setFilter(
                new RequestLoggingFilter(logger)
        );

        registration.addUrlPatterns("/*");

        return registration;
    }
}