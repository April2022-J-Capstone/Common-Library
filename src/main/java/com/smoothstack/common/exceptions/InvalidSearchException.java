package com.smoothstack.common.exceptions;

public class InvalidSearchException extends RuntimeException{

    private String message;

    public InvalidSearchException(String message){
        super(message);
        this.message = message;
    }

    public InvalidSearchException(){};
}
