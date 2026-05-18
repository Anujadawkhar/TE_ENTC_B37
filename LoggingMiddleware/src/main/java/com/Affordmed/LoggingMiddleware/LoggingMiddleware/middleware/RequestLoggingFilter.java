

package com.Affordmed.LoggingMiddleware.LoggingMiddleware.middleware;



import com.Affordmed.LoggingMiddleware.LoggingMiddleware.logger.AppLogger;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

public class RequestLoggingFilter extends OncePerRequestFilter {

    private final AppLogger logger;

    public RequestLoggingFilter(AppLogger logger) {
        this.logger = logger;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        long start = System.currentTimeMillis();

        logger.info(
                request.getMethod() +
                " " +
                request.getRequestURI()
        );

        filterChain.doFilter(request, response);

        long end = System.currentTimeMillis();

        logger.info(
                "Status=" +
                response.getStatus() +
                " Duration=" +
                (end - start) + "ms"
        );
    }
}