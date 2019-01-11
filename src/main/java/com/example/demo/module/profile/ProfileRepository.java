package com.example.demo.module.profile;

import com.example.demo.module.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
