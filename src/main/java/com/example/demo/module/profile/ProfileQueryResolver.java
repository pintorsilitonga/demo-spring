package com.example.demo.module.profile;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProfileQueryResolver implements GraphQLQueryResolver {
    @Autowired private ProfileService profileService;

    public Iterable<Profile> getProfiles() {
        return profileService.getAll();
    }
}
