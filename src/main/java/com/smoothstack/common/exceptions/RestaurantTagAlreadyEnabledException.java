package com.smoothstack.common.exceptions;

public class RestaurantTagAlreadyEnabledException extends RuntimeException {
    private String message;

    public RestaurantTagAlreadyEnabledException(String message){
        super(message);
        this.message = message;
    }

    public RestaurantTagAlreadyEnabledException(){};
}
