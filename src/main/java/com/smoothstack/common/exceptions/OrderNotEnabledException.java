package com.smoothstack.common.exceptions;

public class OrderNotEnabledException extends RuntimeException {

    public OrderNotEnabledException() {
    }

    public OrderNotEnabledException(String msg) {
        super(msg);
    }
}
