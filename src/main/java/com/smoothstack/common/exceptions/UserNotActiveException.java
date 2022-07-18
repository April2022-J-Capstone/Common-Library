package com.smoothstack.common.exceptions;

public class UserNotActiveException extends Exception {

    public UserNotActiveException() {
    }

    public UserNotActiveException(String msg) {
        super(msg);
    }
}
