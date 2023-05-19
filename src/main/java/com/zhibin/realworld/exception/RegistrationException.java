package com.zhibin.realworld.exception;

import org.springframework.http.HttpStatus;

public class RegistrationException extends BaseException{

    public RegistrationException(String message) {
        super(message);
    }
}
