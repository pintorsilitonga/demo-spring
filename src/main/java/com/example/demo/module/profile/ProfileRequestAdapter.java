package com.example.demo.module.profile;

import org.springframework.stereotype.Component;

@Component
public class ProfileRequestAdapter {

    public Profile toProfile(ProfileRequest request) {
        Profile profile = new Profile();

        updateProfile(profile, request);

        return profile;
    }

    public void updateProfile(Profile profile, ProfileRequest request) {
        profile.setUsername(request.getUsername());
        profile.setEmail(request.getEmail());
        profile.setBio(request.getBio());
    }

    public void deactivateProfile(Profile profile) {
        profile.setActive(false);
    }

    public void activateProfile(Profile profile) {
        profile.setActive(true);
    }
}
