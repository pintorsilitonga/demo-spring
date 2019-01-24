package com.example.demo.configuration.security;

import com.example.demo.module.profile.Profile;
import com.example.demo.module.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static final String ERROR_MESSAGE = "username or password is invalid";

    @Autowired private ProfileService profileService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!isUsernameValid(username)) {
            throw new UsernameNotFoundException(username);
        }

        Profile profile = profileService.getByActiveUsername(username);

        return new CustomUserDetails(profile);
    }

    private boolean isUsernameValid(String username) {
        return username != null && !username.isEmpty();
    }
}
