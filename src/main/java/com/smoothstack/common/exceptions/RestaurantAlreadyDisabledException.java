package com.smoothstack.common.exceptions;

public class RestaurantAlreadyDisabledException extends RuntimeException{
    private String message;

    public RestaurantAlreadyDisabledException(String message){
        super(message);
        this.message = message;
    }

    public RestaurantAlreadyDisabledException(){};
}
