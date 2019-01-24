package com.example.demo.module.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
