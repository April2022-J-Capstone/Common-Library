package com.smoothstack.common.exceptions;

public class RestaurantSetUpException extends RuntimeException{
    private String message;

    public RestaurantSetUpException(String message){
        super(message);
        this.message = message;
    }

    public RestaurantSetUpException(){};
}
