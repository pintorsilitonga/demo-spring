package com.example.demo.module.authority;

import com.example.demo.module.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorityRepository
        extends CrudRepository<Authority, String>, JpaRepository<Authority, String> {
    Set<Authority> findByRoles(List<Role> roles);
}
