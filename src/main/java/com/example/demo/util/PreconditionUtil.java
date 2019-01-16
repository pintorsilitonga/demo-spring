package com.example.demo.util;

import com.example.demo.error.ErrorCode;
import com.example.demo.exception.ApplicationException;
import com.example.demo.exception.DataNotFoundException;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public final class PreconditionUtil {
    public static <T> T assertNotNull(T reference, String message) {
        if (reference == null) {
            throw new DataNotFoundException(message);
        }
        return reference;
    }

    public static <T> T assertNotNull(Optional<T> reference, String message) {
        if (!reference.isPresent()) {
            throw new DataNotFoundException(message);
        }
        return reference.get();
    }

    public static void assertTrue(boolean expression, ErrorCode errorCode, String message) {
        if (!expression) {
            throw new ApplicationException(errorCode, message);
        }
    }
}
