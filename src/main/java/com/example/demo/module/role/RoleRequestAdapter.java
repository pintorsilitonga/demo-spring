package com.example.demo.module.role;

import com.example.demo.module.authority.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleRequestAdapter {
    @Autowired
    private AuthorityService authorityService;

    public Role updateRole(Role role, RoleRequest request) {
        role.setName(request.getName());
        role.setDescription(request.getDescription());
        role.setAuthorities(authorityService.getByIds(request.getAuthorityIds()));

        return role;
    }
}
