package com.zhibin.realworld.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException{

    private int errorCode;

    public BaseException(){
        super();
        this.errorCode = 1234;
    }

    public BaseException(String message){
        super(message);
        this.errorCode = 1234;
    }


    public BaseException(int errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
}
