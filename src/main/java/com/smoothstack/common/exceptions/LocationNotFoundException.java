package com.smoothstack.common.exceptions;

public class LocationNotFoundException extends RuntimeException {
    private String message;

    public LocationNotFoundException(String message){
        super(message);
        this.message = message;
    }

    public LocationNotFoundException(){};
}
