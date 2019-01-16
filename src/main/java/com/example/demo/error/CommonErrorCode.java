package com.example.demo.error;

public enum CommonErrorCode implements ErrorCode {
    DATA_NOT_FOUND("COM-001"),
    INVALID_SEARCH_CRITERIA("COM-002"),
    ACCESS_DENIED("COM-003"),
    INVALID_DATA("COM-004"),
    WRITE_FILE_ERROR("COM-005"),
    READ_FILE_ERROR("COM-006");

    private String code;

    CommonErrorCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
