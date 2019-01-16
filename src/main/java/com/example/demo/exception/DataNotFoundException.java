package com.example.demo.exception;

import com.example.demo.error.CommonErrorCode;
import com.example.demo.error.ErrorCode;

public class DataNotFoundException extends RuntimeExceptionWithErrorCode {
    private Class<?> clazz = null;

    public DataNotFoundException(String message, ErrorCode errorCode, Class<?> clazz) {
        super(message, errorCode);
        this.clazz = clazz;
    }

    public DataNotFoundException(String message) {
        this(message, CommonErrorCode.DATA_NOT_FOUND, null);
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
