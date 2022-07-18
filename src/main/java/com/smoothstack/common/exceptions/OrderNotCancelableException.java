package com.smoothstack.common.exceptions;

public class OrderNotCancelableException extends Exception {

    public OrderNotCancelableException() {}

    public OrderNotCancelableException(String message) {
        super(message);
    }
    
}