package com.example.demo.module.profile;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Long>, JpaSpecificationExecutor<Profile> {
    Optional<Profile> findByUsernameAndStatus(String username, ProfileStatus status);
}
