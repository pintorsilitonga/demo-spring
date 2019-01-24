package com.example.demo.exception;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static com.example.demo.util.ConstrainViolationUtil.FormatViolationMessage;

public class GraphqlInvalidFieldException extends RuntimeException {
    public <T> GraphqlInvalidFieldException(Set<ConstraintViolation<T>> violations) {
        super(FormatViolationMessage(violations));
    }
}
