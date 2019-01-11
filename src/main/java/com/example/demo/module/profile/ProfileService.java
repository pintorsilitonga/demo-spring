package com.example.demo.module.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    public Profile addProfile(Profile newProfile) {
        return profileRepository.saveAndFlush(newProfile);
    }

    public Profile getById(Long id) {
        return profileRepository.getOne(id);
    }

    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }
}
