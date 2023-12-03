package com.invaders.healthMate;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e, Model model) {
        // Log the exception details using SLF4J
        logger.error("An unexpected error occurred:", e);

        // Add error details to the model if needed
        model.addAttribute("errorMessage", "An unexpected error occurred.");

        // Return a custom error view or redirect to a specific page
        return "error";
    }

    // Add more @ExceptionHandler methods for specific exceptions if needed
    // For example:
    // @ExceptionHandler(YourSpecificException.class)
    // public String handleYourSpecificException(YourSpecificException ex, Model model) {
    //     // Handle specific exception and return a custom error view
    //     // ...
    // }
}

