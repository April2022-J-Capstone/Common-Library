package com.smoothstack.common.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String msg) {
        super(msg);
    }
}
