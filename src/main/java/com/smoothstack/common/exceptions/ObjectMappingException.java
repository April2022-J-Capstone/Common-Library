package com.smoothstack.common.exceptions;

public class ObjectMappingException extends RuntimeException{
    private String message;

    public ObjectMappingException(String message){
        super(message);
        this.message = message;
    }

    public ObjectMappingException(){};
}
