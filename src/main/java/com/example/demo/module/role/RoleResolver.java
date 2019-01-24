package com.example.demo.module.role;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.module.authority.Authority;
import com.example.demo.module.authority.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RoleResolver implements GraphQLResolver<Role> {
    @Autowired
    private AuthorityService authorityService;

    public Set<Authority> getAuthorities(Role role) {
        return authorityService.getByRole(role);
    }
}
