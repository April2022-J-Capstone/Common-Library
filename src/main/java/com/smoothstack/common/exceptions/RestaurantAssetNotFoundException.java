package com.smoothstack.common.exceptions;

public class RestaurantAssetNotFoundException extends RuntimeException {

    private String message;

    public RestaurantAssetNotFoundException(String message){
        super(message);
        this.message = message;
    }

    public RestaurantAssetNotFoundException(){};

}
