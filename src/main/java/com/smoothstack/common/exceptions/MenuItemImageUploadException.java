package com.smoothstack.common.exceptions;

public class MenuItemImageUploadException extends RuntimeException {

    private String message;

    public MenuItemImageUploadException(String message){
        super(message);
        this.message = message;
    }

    public MenuItemImageUploadException(){};
}
