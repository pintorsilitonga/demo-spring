package com.example.demo.module.profile;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Validator;

import static com.example.demo.util.ConstrainViolationUtil.ValidateRequest;

@Component
@AllArgsConstructor
public class ProfileMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileRequestAdapter profileRequestAdapter;

    @Autowired
    private ProfileRequestValidator profileRequestValidator;

    @Autowired
    private Validator validator;

    @Transactional
    public Profile addProfile(ProfileRequest request) {
        ValidateRequest(validator, request);
        profileRequestValidator.validateNewProfileRequest(request);
        Profile profile = profileRequestAdapter.toProfile(request);
        profileRequestAdapter.activateProfile(profile);

        return profileService.addProfile(profile);
    }

    @Transactional
    public Profile editProfile(Long id, ProfileRequest request) {
        Profile profile = profileService.findById(id);

        profileRequestAdapter.updateProfile(profile, request);

        return profileService.update(profile);
    }

    @Transactional
    public Profile deleteProfile(Long id) {
        Profile profile = profileService.findById(id);

        profileRequestAdapter.deactivateProfile(profile);

        return profileService.update(profile);
    }

    @Transactional
    public Profile undeleteProfile(Long id) {
        Profile profile = profileService.findById(id);

        profileRequestAdapter.activateProfile(profile);

        return profileService.update(profile);
    }
}
