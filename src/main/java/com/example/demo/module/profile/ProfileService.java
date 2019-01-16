package com.example.demo.module.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Iterable<Profile> getAll() {
        return profileRepository.findAll();
    }

    public Profile addProfile(Profile newProfile) {
        return profileRepository.save(newProfile);
    }

    public Profile getById(Long id) {
        return profileRepository.findById(id).get();
    }

    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }
}
