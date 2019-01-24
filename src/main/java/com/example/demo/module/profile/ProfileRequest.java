package com.example.demo.module.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest {
    private String username;
    private String bio;
    private String email;
    private String password;
    @NotNull private Long roleId;
}
