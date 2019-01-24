package com.example.demo.module.role;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository
        extends CrudRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
