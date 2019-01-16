package com.example.demo.module.comment;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.module.profile.Profile;
import com.example.demo.module.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentResolver implements GraphQLResolver<Comment> {
    private ProfileRepository profileRepository;

    public Profile getProfile(Comment comment) {
        return profileRepository.findById(comment.getProfile().getId()).get();
    }
}
