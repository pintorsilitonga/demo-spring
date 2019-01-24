package com.example.demo.module.profile;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.module.role.Role;
import com.example.demo.module.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProfileResolver implements GraphQLResolver<Profile> {
    @Autowired private RoleRepository repository;

    public Role getRole(Profile profile) {
        return repository.findById(profile.getRole().getId()).get();
    }
}
