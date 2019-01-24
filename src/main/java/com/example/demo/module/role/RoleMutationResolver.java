package com.example.demo.module.role;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRequestAdapter adapter;

    public Role addRole(RoleRequest request) {
        Role role = adapter.updateRole(new Role(), request);

        return roleService.save(role);
    }

    public Role editRole(Long id, RoleRequest request) {
        Role role = roleService.findById(id);
        adapter.updateRole(role, request);

        return roleService.save(role);
    }
}
