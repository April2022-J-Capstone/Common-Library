package com.smoothstack.common.exceptions;

public class RestaurantTagAlreadyDisabledException extends RuntimeException {

    private String message;

    public RestaurantTagAlreadyDisabledException(String message){
        super(message);
        this.message = message;
    }

    public RestaurantTagAlreadyDisabledException(){};
}
