package com.zhibin.realworld.config;

import com.zhibin.realworld.exception.ErrorResponse;
import com.zhibin.realworld.exception.LoginException;
import com.zhibin.realworld.exception.RegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionAdvice {

    @ExceptionHandler(RegistrationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(RegistrationException e){
        return new ErrorResponse(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(LoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(LoginException e){
        return new ErrorResponse(e.getErrorCode(), e.getMessage());
    }
}
