package com.example.demo.exception;

import com.example.demo.error.ErrorCode;

public class RuntimeExceptionWithErrorCode extends RuntimeException {
    private ErrorCode errorCode;

    public RuntimeExceptionWithErrorCode(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
