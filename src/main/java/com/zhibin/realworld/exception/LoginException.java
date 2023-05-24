package com.zhibin.realworld.exception;

public class LoginException extends BaseException{

    public LoginException() {
        super("LoginException");
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(int errorCode,String message) {
        super(errorCode, message);
    }
}
