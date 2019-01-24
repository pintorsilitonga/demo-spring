package com.example.demo.module.role;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private RoleService roleService;

    public Role getRole(Long id) {
        return roleService.findById(id);
    }
}
