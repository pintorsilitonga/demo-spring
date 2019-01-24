package com.example.demo.module.profile;

import com.example.demo.module.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProfileRequestAdapter {
    @Autowired private BCryptPasswordEncoder passwordEncoder;
    @Autowired private RoleService roleService;

    public Profile toProfile(ProfileRequest request) {
        Profile profile = new Profile();

        updateProfile(profile, request);

        return profile;
    }

    public void updateProfile(Profile profile, ProfileRequest request) {
        profile.setUsername(request.getUsername());
        profile.setEmail(request.getEmail());
        profile.setBio(request.getBio());
        profile.setRole(roleService.findById(request.getRoleId()));

        if (request.getPassword() != null && !request.getPassword().equals("")) {
            profile.setPassword(passwordEncoder.encode(request.getPassword()));
        }
    }

    public void deactivateProfile(Profile profile) {
        profile.setStatus(ProfileStatus.INACTIVE);
    }

    public void activateProfile(Profile profile) {
        profile.setStatus(ProfileStatus.ACTIVE);
    }
}
