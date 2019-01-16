package com.example.demo.exception;

import com.example.demo.error.ErrorCode;

public class ApplicationException extends RuntimeException {
    public ApplicationException(ErrorCode errorCode, String message) {
        super(errorCode.getCode() + "-" + message);
    }
}
