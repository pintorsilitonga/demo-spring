package com.example.demo.module.profile;

import com.example.demo.error.CommonErrorCode;
import com.example.demo.util.PreconditionUtil;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
public class ProfileRequestValidator {
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    public void validateNewProfileRequest(ProfileRequest request) {
        PreconditionUtil.assertNotNull(request.getUsername(), "Username is empty");

        PreconditionUtil.assertNotNull(request.getPassword(), "Password is empty");
        PreconditionUtil.assertTrue(
                !request.getPassword().equals(""),
                CommonErrorCode.INVALID_DATA, "Password is empty"
        );

        PreconditionUtil.assertTrue(
                request.getPassword().length() >= MINIMUM_PASSWORD_LENGTH,
                CommonErrorCode.INVALID_DATA,
                "Minimum 8 size is characters"
        );

        PreconditionUtil.assertTrue(
                request.getBio().length() > 0,
                CommonErrorCode.INVALID_DATA,
                "Biodata is empty"
        );

        PreconditionUtil.assertTrue(
                EmailValidator.getInstance().isValid(request.getEmail()),
                CommonErrorCode.INVALID_DATA,
                "Invalid email"
        );

        PreconditionUtil.assertNotNull(request.getRoleId(), "Role is empty");
    }
}
