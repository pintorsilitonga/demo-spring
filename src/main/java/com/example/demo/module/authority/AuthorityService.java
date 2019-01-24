package com.example.demo.module.authority;

import com.example.demo.module.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority findById(String id) {
        return authorityRepository.findById(id).get();
    }

    public Set<Authority> getByRole(Role role) {
        return authorityRepository.findByRoles(Arrays.asList(role));
    }

    public Set<Authority> getByIds(Set<String> ids) {
        return new HashSet<>(authorityRepository.findAllById(ids));
    }
}
