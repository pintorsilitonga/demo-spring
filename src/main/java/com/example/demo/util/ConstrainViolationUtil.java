package com.example.demo.util;

import com.example.demo.exception.GraphqlInvalidFieldException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public final class ConstrainViolationUtil {
    public static <T> void ValidateRequest(Validator validator, T request) {
        Set<ConstraintViolation<T>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new GraphqlInvalidFieldException(violations);
        }
    }

    public static <T> String FormatViolationMessage(Set<ConstraintViolation<T>> violations) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (ConstraintViolation<T> violation : violations) {
            sb.append(violation.getPropertyPath());
            sb.append(": ");
            sb.append(violation.getMessage());
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
