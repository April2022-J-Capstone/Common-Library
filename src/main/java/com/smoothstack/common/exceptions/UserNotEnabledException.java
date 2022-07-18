package com.smoothstack.common.exceptions;

public class UserNotEnabledException extends Exception {

    public UserNotEnabledException() {
    }

    public UserNotEnabledException(String msg) {
        super(msg);
    }
}
