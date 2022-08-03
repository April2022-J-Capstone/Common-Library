package com.smoothstack.common.exceptions;

public class BucketExistsException extends RuntimeException{
    private String message;

    public BucketExistsException(String message){
        super(message);
        this.message = message;
    }

    public BucketExistsException(){};
}
