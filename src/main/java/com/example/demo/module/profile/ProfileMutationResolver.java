package com.example.demo.module.profile;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class ProfileMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileRequestAdapter profileRequestAdapter;

    @Transactional
    public Profile addProfile(ProfileRequest request) {
        Profile profile = profileRequestAdapter.toProfile(request);

        return profileService.addProfile(profile);
    }

    @Transactional
    public Profile editProfile(Long id, ProfileRequest request) {
        Profile profile = profileService.getById(id);

        profileRequestAdapter.updateProfile(profile, request);

        return profileService.update(profile);
    }

    @Transactional
    public Profile deleteProfile(Long id) {
        Profile profile = profileService.getById(id);

        profileRequestAdapter.deactivateProfile(profile);

        return profileService.update(profile);
    }

    @Transactional
    public Profile undeleteProfile(Long id) {
        Profile profile = profileService.getById(id);

        profileRequestAdapter.activateProfile(profile);

        return profileService.update(profile);
    }
}
