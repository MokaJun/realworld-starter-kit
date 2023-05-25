package com.zhibin.realworld.exception;

public class UserNotExistException extends BaseException{

    public UserNotExistException() {
        super("UserNotExistException");
    }

    public UserNotExistException(String message) {
        super(message);
    }

    public UserNotExistException(int errorCode, String message) {
        super(errorCode, message);
    }
}
