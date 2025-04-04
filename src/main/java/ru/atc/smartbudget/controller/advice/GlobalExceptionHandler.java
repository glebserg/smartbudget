package ru.atc.smartbudget.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import ru.atc.smartbudget.exception.*;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFound(UserNotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }

    @ExceptionHandler(IncomeCategoryNotFoundException.class)
    public ErrorResponse handleIncomeCategoryNotFound(IncomeCategoryNotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Income category not found");
    }

    @ExceptionHandler(IncomeNotFoundException.class)
    public ErrorResponse handleIncomeNotFound(IncomeNotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Income not found");
    }

    @ExceptionHandler(OutlayCategoryNotFoundException.class)
    public ErrorResponse handleOutlayCategoryNotFound(OutlayCategoryNotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Outlay category not found");
    }

    @ExceptionHandler(OutlayNotFoundException.class)
    public ErrorResponse handleOutlayNotFound(OutlayNotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Outlay not found");
    }
}

