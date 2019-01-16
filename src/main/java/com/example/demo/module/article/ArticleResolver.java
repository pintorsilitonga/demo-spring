package com.example.demo.module.article;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.module.comment.Comment;
import com.example.demo.module.comment.CommentRepository;
import com.example.demo.module.profile.Profile;
import com.example.demo.module.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class ArticleResolver implements GraphQLResolver<Article> {
    @Autowired private CommentRepository commentRepository;
    @Autowired private ProfileRepository profileRepository;

    public Profile getProfile(Article article) {
        return profileRepository.findById(article.getProfile().getId()).get();
    }

    public List<Comment> getComments(Article article) {
        return commentRepository.findByArticleId(article.getId());
    }
}
